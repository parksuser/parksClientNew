package com.tlalim.masa.parksclient.parsetables;

import com.parse.ParseFile;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marina on 27.12.2015.
 */
public class News {
    private String objectID;
    private String title;
    private Date dateToPublish;
    private String previewtext;
    private ParseFile previewpic;
    private String text;
    private ArrayList<ParseFile> pics;


    public News(String objectID, String title, Date dateToPublish, String previewtext, ParseFile previewpic, ArrayList<ParseFile> pics, String text) {
        this.objectID = objectID;
        this.title = title;
        this.dateToPublish = dateToPublish;
        this.previewtext = previewtext;
        this.previewpic = previewpic;
        this.pics = pics;
        this.text = text;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateToPublish() {
        return dateToPublish;
    }

    public void setDateToPublish(Date dateToPublish) {
        this.dateToPublish = dateToPublish;
    }

    public String getPreviewtext() {
        return previewtext;
    }

    public void setPreviewtext(String previewtext) {
        this.previewtext = previewtext;
    }

    public ParseFile getPreviewpic() {
        return previewpic;
    }

    public void setPreviewpic(ParseFile previewpic) {
        this.previewpic = previewpic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<ParseFile> getPics() {
        return pics;
    }

    public void setPics(ArrayList<ParseFile> pics) {
        this.pics = pics;
    }


    @Override
    public String toString() {
        return dateToPublish.toString();
    }
}
