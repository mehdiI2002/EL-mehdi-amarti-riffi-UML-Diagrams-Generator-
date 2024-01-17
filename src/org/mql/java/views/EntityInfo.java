package org.mql.java.views;

import javax.swing.JPanel;

public class EntityInfo {
    private String entityName;
    private JPanel panel;
    private int index;

    public EntityInfo(String entityName, JPanel panel, int index) {
        this.entityName = entityName;
        this.panel = panel;
        this.index = index;
    }

   
	public String getEntityName() {
        return entityName;
    }

    @Override
	public String toString() {
		return "EntityInfo [entityName=" + entityName + ", panel=" + panel + ", index=" + index + "]";
	}


	public JPanel getPanel() {
        return panel;
    }

    public int getIndex() {
        return index;
    }
}
