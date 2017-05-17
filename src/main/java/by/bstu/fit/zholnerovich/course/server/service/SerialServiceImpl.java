package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Episode;
import by.bstu.fit.zholnerovich.course.server.entity.Serial;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.repository.EpisodeRepository;
import by.bstu.fit.zholnerovich.course.server.repository.SerialRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class SerialServiceImpl implements ISerialService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SerialRepository serialRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    private static final String ALL_SERIALS_URL = "https://myshows.me/search/all/?page=";
    private static final String SERIAL_URL = "https://myshows.me/view/";

    public String answer(String username, String password) {
        List<User> list = userRepository.findAll();
        for (User user : list){
            if (user.getLogin().equals(username) && user.getPassword().equals(password)){
                return "Successful";
            }
        }
        return "SUKA BLYAT'!";
    }

    public String getSerials() {
        for (int i = 0; i < 50; i++){
            try {
                Document document = Jsoup.connect(ALL_SERIALS_URL + i).get();

                Elements elements = document.getElementsByTag("tr");
                elements.remove(0);

                for (Element element : elements) {
                    Element myElement = element.child(0).child(0);
                    String idS = myElement.attr("href").split("/", 6)[4];
                    Long id = Long.parseLong(idS);
                    String name = myElement.text();
                    String subname = element.child(0).child(2).text();
                    boolean status = false;
                    if(element.child(0).child(1).attr("class").equals("status _onair"))
                        status = true;
                    Date date = new Date();

                    document = Jsoup.connect(SERIAL_URL + id + "/").get();

                    Elements Seasons = document.getElementsByAttributeValue("itemprop", "season");
                    String lastEpisode = "" + Seasons.size() + ":";
                    Element episode = Seasons.get(0).getElementsByAttributeValue("itemprop", "episodeNumber").get(0);
                    lastEpisode += episode.attr("content");
//                    serialRepository.saveAndFlush(new Serial(id, name, subname, lastEpisode, status, date));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return "All serials was added to database!";
    }

    public List<Episode> getAll() {
        return episodeRepository.findAll();
    }
}
