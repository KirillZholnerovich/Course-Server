package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Serial;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.repository.SerialsRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UsersRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SerialService implements ISerialService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SerialsRepository serialsRepository;

    public String answer(String username, String password) {
        List<User> list = usersRepository.findAll();
        for (User user : list){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return "Successful";
            }
            else return "SUKA BLYAT'!";
        }
        return "Error!";
    }

    public String getSerials() {
        for (int i = 0; i < 50; i++){
            try {
                Document document = Jsoup.connect("https://myshows.me/search/all/?page=" + i).get();

                Elements elements = document.getElementsByTag("tr");
                elements.remove(0);

                for (Element element : elements) {
                    Element myElement = element.child(0).child(0);
                    String idS = myElement.attr("href").split("/", 6)[4];
                    Long id = Long.parseLong(idS);
                    String name = myElement.text();
                    String subname = element.child(0).child(2).text();
                    serialsRepository.saveAndFlush(new Serial(id, name, subname));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return "All serials was added to database!";
    }
}
