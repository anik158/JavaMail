package com.ahsan.controller;

import com.ahsan.EmailManager;
import com.ahsan.view.ViewFactory;


public abstract class BaseController {
    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(EmailManager emailManager, String fxmlName, ViewFactory viewFactory) {
        this.emailManager = emailManager;
        this.fxmlName = fxmlName;
        this.viewFactory = viewFactory;
    }

    public String getName() {
        return this.fxmlName;
    }
}
