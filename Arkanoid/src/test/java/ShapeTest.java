import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShapeTest {

	@Mock
	Graphics g;

	Shape shape;

	@Test
	public void testShapeBounds() {
		shape = new MyShapeVisibleTrue(0, 0, 1, 2, Color.BLUE);
		Assert.assertEquals(0, shape.getBounds2D().getY(), 0);
		Assert.assertEquals(0, shape.getBounds2D().getX(), 0);
		Assert.assertEquals(1, shape.getBounds2D().getWidth(), 0);
		Assert.assertEquals(2, shape.getBounds2D().getHeight(), 0);
	}

	@Test
	public void testDrawWhenShapeIsNotVisible() {
		shape = new MyShapeVisibleFalse(0, 0, 0, 0, Color.BLUE);
		Graphics g = new GraphipcsTest();
		shape.draw(g);
		Assert.assertEquals(Color.BLUE, shape.getColor());

	}

	@Test
	public void testDrawWhenShapeIsVisible() {
		shape = new MyShapeVisibleTrue(0, 0, 1, 2, Color.BLUE);
		Graphics g = new GraphipcsTest();
		shape.draw(g);
		Assert.assertNotNull(g.getColor());
		Assert.assertEquals(0, g.getClipBounds().getY(), 0);
		Assert.assertEquals(0, g.getClipBounds().getX(), 0);
		Assert.assertEquals(1, g.getClipBounds().getWidth(), 0);
		Assert.assertEquals(2, g.getClipBounds().getHeight(), 0);
	}

	@Test
	public void testDrawWhenShapeIsVisibleWithMockGraphics() {
		shape = new MyShapeVisibleTrue(0, 0, 1, 2, Color.BLUE);
		shape.draw(g);
		verify(g).setColor(Color.BLUE);
		verify(g).fillRect(eq(0), eq(0), anyInt(), anyInt());
	}

	@Test
	public void testColor() {
		shape = new MyShapeVisibleFalse(0, 0, 0, 0, Color.BLUE);
		Assert.assertEquals(Color.BLUE, shape.getColor());
	}

	@Before
	public void setUp() throws Exception {
	}

	class MyShapeVisibleTrue extends Shape {

		public MyShapeVisibleTrue(int x, int y, int width, int height, Color color) {
			super(x, y, width, height, color);
		}

		@Override
		public boolean isVisible() {
			return visible;
		}
	}

	class MyShapeVisibleFalse extends Shape {


		public MyShapeVisibleFalse(int x, int y, int width, int height, Color color) {
			super(x, y, width, height, color);
		}

		@Override
		public boolean isVisible() {
			return false;
		}
	}

	class GraphipcsTest extends Graphics {

		private Color color;
		private Rectangle rectangle;

		@Override
		public Graphics create() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void translate(int x, int y) {
			// TODO Auto-generated method stub

		}

		@Override
		public Color getColor() {
			return color;
		}

		@Override
		public void setColor(Color c) {
			color = c;
		}

		@Override
		public void setPaintMode() {
			// TODO Auto-generated method stub

		}

		@Override
		public void setXORMode(Color c1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Font getFont() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFont(Font font) {
			// TODO Auto-generated method stub

		}

		@Override
		public FontMetrics getFontMetrics(Font f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Rectangle getClipBounds() {
			return rectangle;
		}

		@Override
		public void clipRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setClip(int x, int y, int width, int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public java.awt.Shape getClip() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setClip(java.awt.Shape clip) {
			// TODO Auto-generated method stub

		}

		@Override
		public void copyArea(int x, int y, int width, int height, int dx, int dy) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fillRect(int x, int y, int width, int height) {
			rectangle = new Rectangle(x, y, width, height);

		}

		@Override
		public void clearRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fillOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub

		}

		@Override
		public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawString(String str, int x, int y) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drawString(AttributedCharacterIterator iterator, int x, int y) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor,
				ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}
	}

}
