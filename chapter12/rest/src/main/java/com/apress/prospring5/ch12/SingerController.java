package com.apress.prospring5.ch12;

import com.apress.prospring5.ch12.entities.Singer;
import com.apress.prospring5.ch12.entities.Singers;
import com.apress.prospring5.ch12.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/rest/singer")
public class SingerController {
    final Logger logger = LoggerFactory.getLogger(SingerController.class);

    @Autowired
    private SingerService singerService;

    @ResponseStatus(HttpStatus.OK)
    //@RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    @GetMapping(value = "/listdata")
    public Singers listData() {
        return new Singers(singerService.findAll());
    }

    //@RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Singer findSingerById(@PathVariable Long id) {
        return singerService.findById(id);
    }

    //@RequestMapping(value="/", method=RequestMethod.POST)
    @ResponseBody
    @PostMapping(value="/")
    public Singer create(@RequestBody Singer singer) {
        logger.info("Singer 생성: " + singer);
        singerService.save(singer);
        logger.info("Singer 정보 생성 성공: " + singer);
        return singer;
    }

    //@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    @PutMapping(value="/{id}")
    public void update(@RequestBody Singer singer,
                       @PathVariable Long id) {
        logger.info("Singer 수정: " + singer);
        singerService.save(singer);
        logger.info("Singer 수정 성공: " + singer);
    }

    //@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id) {
        logger.info("아이디가 " + id + "인 Singer 삭제");
        Singer singer = singerService.findById(id);
        singerService.delete(singer);
        logger.info("Singer 삭제 성공");
    }
}
