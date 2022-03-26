package mobility;

public class Mobile implements Ilocatable {

    private Point location;
    private double totalDistance;

    public Mobile(Point location){
        this.location = location;
        this.totalDistance = 0;

    }
    public void addTotalDistance(double distance){
        this.totalDistance += distance;
    }
    public double calcDistance(Point newLocation){
        double X = newLocation.getX() - this.location.getX();
        double Y = newLocation.getY() - this.location.getY();
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
    }
    public double move(Point p){
        double distanceTraveled = this.calcDistance(p);
        this.addTotalDistance(distanceTraveled);
        this.setLocation(p);
        return distanceTraveled;
    }
    public Point getLocation() {
        return location;

    }
    public boolean setLocation(Point p){
        this.location = p;
        return true;
    }
}
