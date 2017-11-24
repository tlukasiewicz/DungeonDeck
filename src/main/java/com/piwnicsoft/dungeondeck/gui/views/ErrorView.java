package com.piwnicsoft.dungeondeck.gui.views;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
@SpringComponent
@UIScope
@SpringView(name = ErrorView.VIEW_NAME)
public class ErrorView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "error";

    @PostConstruct
    void init() {
        addComponent(new Label("Something went terribly wrong..."));
    }
}

