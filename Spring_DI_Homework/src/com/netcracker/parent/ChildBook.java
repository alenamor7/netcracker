package com.netcracker.parent;

public class ChildBook extends ParentBook {
    private String title;
    private int pages;
    private String publishing;

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    @Override
    public String toString() {
        return "ChildBook{" +
                "title='" + title + '\'' +
                "author='" + getAuthor() + '\''+
                ", pages=" + pages +
                ", publishing='" + publishing + '\'' +
                '}';
    }
}
