package org.docear.plugin.pdfutilities.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.docear.plugin.pdfutilities.util.Tools;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AnnotationConflictPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public AnnotationConflictPanel() {
		init();
	}
	
	public AnnotationConflictPanel(Integer objectNumber) {
		init();
		this.setTitle(objectNumber);
	}
	

	private void init() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("top:default"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),}));
		
		label = new JLabel("Conflict at Bookmark [Objectnumber ?] [PDF Bookmark name ?]");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(label, "1, 1");
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel, "1, 3, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("5dlu"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("5dlu"),},
			new RowSpec[] {
				RowSpec.decode("top:5dlu"),
				RowSpec.decode("bottom:5dlu"),}));
	}
	
	public void setTitle(Integer objectNumber){
		label.setText("Conflict at Annotation " + objectNumber);
	}
	
	public void setTitle(String annotationTitle){
		label.setText("Conflict at Annotation \"" + Tools.reshapeString(annotationTitle, 100) + "\"");
	}

	public void addDropdownBoxPanel(AnnotationConflictDropdownBoxPanel dropdownBoxPanel){
		FormLayout formLayout = (FormLayout)panel.getLayout();		
		if(formLayout.getRowCount() > 2){
			formLayout.insertRow(formLayout.getRowCount(), FormFactory.NARROW_LINE_GAP_ROWSPEC);
		}
		
		formLayout.insertRow(formLayout.getRowCount(), RowSpec.decode("top:20px"));		
		this.panel.add(dropdownBoxPanel, "2, " + (formLayout.getRowCount() - 1) + ", fill, top");
	}
	
	

}