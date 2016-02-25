package com.beauty.entity;

public class BeautyMessage extends BaseEntity {

    private static final long serialVersionUID = 2302052364927330261L;

    private Long id;

    private String messageHead;

    private String messageBody;

    private Byte status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageHead() {
        return messageHead;
    }

    public void setMessageHead(String messageHead) {
        this.messageHead = messageHead == null ? null : messageHead.trim();
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody == null ? null : messageBody.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


}