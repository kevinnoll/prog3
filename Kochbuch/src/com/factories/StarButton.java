package com.factories;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JToggleButton;

public class StarButton extends JToggleButton {
	private boolean armed;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StarButton(String text){
		super(text);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}
	
	public static Shape makeStarDesign(int arms, Point center, double r_out, double r_in) {
	     double angle = Math.PI / arms;
	     GeneralPath path = new GeneralPath();
	     for (int i = 0; i < 2 * arms; i++) {
	          double r = (i & 1) == 0 ? r_out : r_in;
	          Point2D.Double p = new Point2D.Double(center.x + Math.cos(i * angle) * r, center.y + Math.sin(i * angle) * r);
	          if (i == 0) path.moveTo(p.getX(), p.getY());
	          else path.lineTo(p.getX(), p.getY());
	     }
	     path.closePath();
	     return path;
	}
		
	protected void paintComponent(Graphics g) {
		 if(getModel().isSelected()) {
	          g.setColor(Color.YELLOW);
	     } else {
	          g.setColor(getBackground());
	     }
	     Graphics2D graphics2d = (Graphics2D) g;
	     graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	     graphics2d.fill(makeStarDesign(5, new Point(50,50), 50, 30));
	     graphics2d.fill(makeStarDesign(5, new Point(15,15), 15, 9));
	     super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
	     g.setColor(getForeground());
	     Graphics2D graphics2d = (Graphics2D) g;
	     graphics2d.draw(makeStarDesign(5, new Point(15,15), 15, 9));
	}
	Shape shape;
	public boolean contains(int x, int y) {
	     if (shape == null || !shape.getBounds().equals(getBounds())) {
	          shape = new Area(makeStarDesign(5, new Point(15,15), 15, 9));
	     }
	     return shape.contains(x, y);
	}
}
