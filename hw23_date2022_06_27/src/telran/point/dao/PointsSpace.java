package telran.point.dao;

import java.util.Arrays;
import java.util.Comparator;

import telran.point.model.Point;

public class PointsSpace {
	Point relPoint;
	Point[] points;
	Comparator<Point> comp;

	public PointsSpace(Point relPoint, Point[] points) {
		this.relPoint = relPoint;
		this.comp = (p1, p2) -> Double.compare(getRangeToRel(p1), getRangeToRel(p2));
		this.points = new Point[points.length];
		System.arraycopy(points, 0, this.points, 0, points.length);
		Arrays.sort(this.points, this.comp);
	}

	public Point[] getPoints() {
		return this.points;
	}
	public Comparator<Point> getComparator() {
		return this.comp;
	}

	public void addPoint(Point point) {
		int index = Arrays.binarySearch(points, point, comp);
		index = index < 0 ? -index - 1 : index;
		Point[] temp = new Point[this.points.length + 1];
		System.arraycopy(this.points, 0, temp, 0, index);
		temp[index] = point;
		System.arraycopy(this.points, index, temp, index + 1, points.length - index);
		this.points = temp;
	}

	private double getRangeToRel(Point p) {
		return Math.sqrt(Math.pow((p.getX() - relPoint.getX()), 2) + Math.pow((p.getY() - relPoint.getY()), 2));
	}
}
