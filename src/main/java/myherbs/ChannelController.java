package myherbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tezra on 8/8/15.
 */
@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    @Autowired
    ChannelRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List channelList() {
        return repository.findAll();
    }
}
