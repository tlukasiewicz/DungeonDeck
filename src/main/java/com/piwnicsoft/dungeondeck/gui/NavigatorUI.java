package com.piwnicsoft.dungeondeck.gui;

import com.piwnicsoft.dungeondeck.gui.views.AdventureView;
import com.piwnicsoft.dungeondeck.gui.views.ErrorView;
import com.piwnicsoft.dungeondeck.gui.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;

@Slf4j
@SpringUI
@Theme("valo")
@AllArgsConstructor
public class NavigatorUI extends UI {

    @Autowired
    private MainViewDisplay mainContent;

    @Autowired
    private SpringNavigator navigator;

    @PostConstruct
    void init() {
        navigator.setErrorView(ErrorView.class);
    }

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("DungeonDeck");

        setContent(
                new MVerticalLayout()
                        .add(createNavigationBar())
                        .expand(mainContent)
                        .withFullHeight()
        );
    }

    private Component createNavigationBar() {
        MenuBar barmenu = new MenuBar();
        barmenu.addItem("Strona Główna", createNavButton(MainView.VIEW_NAME));
        barmenu.addItem("Nowa Przygoda", createNavButton(AdventureView.VIEW_NAME));
        barmenu.addItem("Karty postaci", createNavButton(ErrorView.VIEW_NAME));
        barmenu.addItem("Ekwipunek", createNavButton(ErrorView.VIEW_NAME));
        return barmenu;
    }

    private MenuBar.Command createNavButton(String viewName) {
        return m -> navigator.navigateTo(viewName);
    }
}
