package org.jboss.errai.widgets.client.format;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.errai.widgets.client.WSGrid;
import org.jboss.errai.widgets.client.icons.ErraiWidgetsImageBundle;


public class WSCellTitle extends WSCellFormatter<String> {
    HorizontalPanel hPanel = new HorizontalPanel();
    HTML label = new HTML();
    Image img = new Image();

    WSGrid.WSCell cell;

    ErraiWidgetsImageBundle imageBundle = GWT.create(ErraiWidgetsImageBundle.class);

    public WSCellTitle(WSGrid.WSCell cell, String title) {
        this.cell = cell;

        label.setHTML(title);
        hPanel.add(label);
        hPanel.add(img);
        hPanel.setWidth("100%");
        hPanel.setCellWidth(img, "16px");

        img.setVisible(false);
        img.getElement().getStyle().setProperty("textAlign", "right");

    }

    public void setValue(String value) {
        label.setHTML(value);
    }

    @Override
    public String getValue() {
        return label.getText();
    }

    public String getTextValue() {
        return label.getHTML();
    }

    public Widget getWidget(WSGrid wsGrid) {
        if (wsGrid.getSortedColumnHeader() == cell) {

            if (wsGrid.getColumnSortOrder(cell.getCol()))
                img.setUrl(imageBundle.sortDown().getURL());
            else
                img.setUrl(imageBundle.sortUp().getURL());

            img.setVisible(true);
        }
        else {
            img.setVisible(false);
        }

        return hPanel;
    }

    @Override
    public void setHeight(String height) {
    }

    @Override
    public void setWidth(String width) {
    }

    public boolean edit(WSGrid.WSCell element) {
        return false;
    }

    public void stopedit() {
    }
}
