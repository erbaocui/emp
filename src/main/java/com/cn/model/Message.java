package com.cn.model;

import java.util.Date;

public class Message {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.Id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.send_time
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.picture
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_message.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbggenerated
     */
    public Message(String id, String title, String content, String status, Date sendTime, String picture, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.sendTime = sendTime;
        this.picture = picture;
        this.url = url;
    }

    public Message() {
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.Id
     *
     * @return the value of t_message.Id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.title
     *
     * @return the value of t_message.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.content
     *
     * @return the value of t_message.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.status
     *
     * @return the value of t_message.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.send_time
     *
     * @return the value of t_message.send_time
     *
     * @mbggenerated
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.picture
     *
     * @return the value of t_message.picture
     *
     * @mbggenerated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_message.url
     *
     * @return the value of t_message.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}