package mobility;

public class Mobile implements ILocatable {

    private Point location;
    private double totalDistance;

    public Mobile(Point location){
        this.location = location;
        this.totalDistance = 0;

    }
    //API
    public void addTotalDistance(double distance){
        this.totalDistance += distance;
    }
    public double calcDistance(Point newLocation){
        double X = newLocation.getX() - this.location.getX();
        double Y = newLocation.getY() - this.location.getY();
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
    }
    public double move(Point newLocation){
        if(this.setLocation(newLocation)){
            double distanceTraveled = this.calcDistance(newLocation);
            this.addTotalDistance(distanceTraveled);
            return distanceTraveled;
        }
        return 0;
    }

    //setters
    public boolean setLocation(Point point) {
        boolean isSuccess = Point.checkBoundaries(point);
        if (isSuccess) {
            this.location = new Point(point);
        }
        return isSuccess;
    }
    //getters
    public Point getLocation() {
        return this.location;
    }
}
