package com.gaurav.restify.beans.dbpostbeans;

import com.gaurav.restify.beans.Response;
import com.gaurav.restify.configuration.configurationBeans.RestJob;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RestJobPostBean extends RestJob {

    private Response response;

    private String timeStamp;

    public RestJobPostBean(Response response) {
        this.response = response;
        setTimeStamp();
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public void setRestJob(RestJob restJob) {
        this.setAlias(restJob.getAlias());
        this.setArgsCommand(restJob.getArgsForCommand());
        this.setArgsCommandType(restJob.getArgsForCommandType());
        this.setPath(restJob.getPath());
        this.setWaitTime(restJob.getWaitTime());
        this.setCommand(restJob.getCommand());
        this.setCommandType(restJob.getCommandType());


    }
}
