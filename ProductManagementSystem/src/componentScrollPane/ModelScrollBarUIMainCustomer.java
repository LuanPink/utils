package componentScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

import color.ColorBackground;

public class ModelScrollBarUIMainCustomer extends BasicScrollBarUI {

	private int THUMB_SIZE = 200;
	private Color color1 = ColorBackground.colorLight;
	private Color color2 = Color.decode("#D96A77");
	
	
	@Override
	protected Dimension getMaximumThumbSize() {
		if(scrollbar.getOrientation()== JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		}else {
			return new Dimension(THUMB_SIZE ,0);
		}
	}
	
	@Override
	protected Dimension getMinimumThumbSize() {
		if(scrollbar.getOrientation()== JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		}else {
			return new Dimension(THUMB_SIZE ,0);
		}
	}
	
	 @Override
	    protected JButton createIncreaseButton(int i) {
	        return new ScrollBarButton();
	    }

	    @Override
	    protected JButton createDecreaseButton(int i) {
	        return new ScrollBarButton();
	    }
	
	    @Override
	    protected void paintTrack(Graphics g, JComponent c, Rectangle rctngl) {
	    	 Graphics2D g2 = (Graphics2D) g;
	         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	         int orientation = scrollbar.getOrientation();
	         int size;
	         int x;
	         int y;
	         int width;
	         int height;
	         if (orientation == JScrollBar.VERTICAL) {
	             size = rctngl.width;
	             x = rctngl.x + ((rctngl.width - size) / 2);
	             y = rctngl.y;
	             width = size;
	             height = rctngl.height;
	         } else {
	             size = rctngl.height;
	             y = rctngl.y + ((rctngl.height - size) / 2);
	             x = 0;
	             width = rctngl.width;
	             height = size;
	         }
	         g2.setColor(color1);
	         g2.fillRect(0, 0, width, height + 5);
	    }
	
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle rectangle) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = rectangle.x;
		int y = rectangle.y;
		int width = rectangle.width;
		int height = rectangle.height;
		if(scrollbar.getOrientation()==JScrollBar.VERTICAL) {
			y+= 8;
			height -=16;
			
		}else {
			x +=8;
			width -= 16;
		}
		g2.setColor(color2);
		g2.fillRoundRect(x, y, width, height, 5, 5);
	}
	
	private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
        	
        }
    }

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	
	

}
