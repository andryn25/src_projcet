package com.catering.view.swing;

import com.catering.view.model.Menu;

public class ListMenu<E extends Object> extends javax.swing.JList<E> {

    private final javax.swing.DefaultListModel dlModel;
    private int selectedIndex = -1;

    public ListMenu() {
        dlModel = new javax.swing.DefaultListModel();
        setModel(dlModel);
        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent me) {
                if (javax.swing.SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = dlModel.getElementAt(index);
                    if (o instanceof Menu) {
                        Menu menu = (Menu) o;
                        if (menu.getType() == Menu.MenuType.MENU) {
                            selectedIndex = index;
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }

        });
    }

    @Override
    public javax.swing.ListCellRenderer<? super E> getCellRenderer() {
        return new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> jList, Object o, int index, boolean selected, boolean focus) {
                Menu menu;
                if (o instanceof Menu) {
                    menu = (Menu) o;
                } else {
                    menu = new Menu("", o + "", Menu.MenuType.EMPTY);
                }
                MenuItem menuItem = new MenuItem(menu);
                menuItem.setSelected(selectedIndex == index);
                return menuItem;
            }
        };
    }

    public void addItem(Menu menu) {
        dlModel.addElement(menu);
    }

}
