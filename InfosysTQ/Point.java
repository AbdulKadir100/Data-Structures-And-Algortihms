package InfosysTQ;

class Point2 {
    //Implement your code here
    private double xCordinate;
    private double yCordinate;

    public Point2(double xCordinate, double yCordinate) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
    }


    public double getxCordinate() {
        return xCordinate;
    }

    public void setxCordinate(double xCordinate) {
        this.xCordinate = xCordinate;
    }

    public double getyCordinate() {
        return yCordinate;
    }

    public void setyCordinate(double yCordinate) {
        this.yCordinate = yCordinate;
    }

    public double calculateDistance() {
        double ans=0.0;
        ans = xCordinate-yCordinate;
        return ans;

    }
    public
    double calculateDistance(Point2 point2){
        double x1 = point2.getxCordinate();
        double x2 = point2.getxCordinate();
        double y1 = point2.getyCordinate();
        double y2 = point2.getyCordinate();
        double r1 = x2-x1;
        double r2 = y2-y1;
        double sqr1 = Math.pow(r1,2);
        double sqr2 = Math.pow(r2,2);

        double distance = Math.sqrt((sqr1+sqr2));
        return Math.round(distance);
    }
}
class Point {

    public static void main(String[] args) {
        Point2 point1 = new Point2(3.5, 1.5);
        Point2 point2 = new Point2(6, 4);

        System.out.println("Distance of point1 from origin is "+point1.calculateDistance());
        System.out.println("Distance of point2 from origin is "+point2.calculateDistance());
        //System.out.println("Distance of point1 from point2 is "+point1.calculateDistance(point2));

        //Create more objects for testing your code

    }
}

