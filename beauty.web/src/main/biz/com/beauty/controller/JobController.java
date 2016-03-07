package com.beauty.controller;

import com.beauty.entity.BeautyJob;
import com.beauty.entity.BeautyJob;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.quartz.entity.ScheduleJob;
import com.beauty.service.JobService;
import com.beauty.service.QueueService;
import com.beauty.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Page queryPage(HttpServletRequest request) {
        Page page = new Page();
        page.init(request);
        Map<String, Object> params = new HashMap<String, Object>();
        page.pageToMap(params);
        int count = this.jobService.selectCount(params);
        List<?> list = this.jobService.selectPage(params);
        page.setResult(list, count + "", count + "");
        return page;
    }


    @RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Value persist(BeautyJob entity) {
        this.jobService.insertSelective(entity);
        return new Value(CodeUtil.ADD_SUCCESS);
    }

    @RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Value modify(BeautyJob entity) {
        this.jobService.updateByPrimaryKeySelective(entity);
        return new Value(CodeUtil.EDIT_SUCCESS);
    }

    @RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Value delete(Value value) {
        if (!value.getValues().isEmpty()) {
            List<?> jobs = this.jobService.selectByPrimaryKeys(value.getValues());
            for (Object obj : jobs) {
                BeautyJob job = (BeautyJob) obj;
                ScheduleJob scheduleJob = ScheduleJob._JOB_MAP.get(job.getName());
                if (null != scheduleJob) {
                    scheduleJob.delete();
                }
            }
            this.jobService.deleteByPrimaryKeys(value.getValues());
        }
        return new Value(CodeUtil.DELETE_SUCCESS);
    }

    @RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
    @ResponseBody
    public BeautyJob load(@RequestParam("id") Long id) {
        return this.jobService.selectByPrimaryKey(id);
    }

}
