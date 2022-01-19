/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class Vector3D {
    /**
     * Getters, setters and constructors of the class
     */
    private static final Vector3D ZERO = new Vector3D(0.0, 0.0, 0.0);
    private double x, y, z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * Calculate the dot proouct of two vectors
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static double dotProduct(Vector3D vectorA, Vector3D vectorB){
        return (vectorA.getX() * vectorB.getX()) + (vectorA.getY() * vectorB.getY()) + (vectorA.getZ() * vectorB.getZ());
    }

    /**
     * Calculate the cross product  of two vectors
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static Vector3D crossProduct(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D((vectorA.getY() * vectorB.getZ()) - (vectorA.getZ() * vectorB.getY()),
                (vectorA.getZ() * vectorB.getX()) - (vectorA.getX() * vectorB.getZ()),
                (vectorA.getX() * vectorB.getY()) - (vectorA.getY() * vectorB.getX()));
    }

    /**
     * Calculate the magnitude of a vector
     * @param vectorA
     * @return
     */
    public static double magnitude(Vector3D vectorA){
        return Math.sqrt(dotProduct(vectorA, vectorA));
    }

    /**
     * add one vector to another
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static Vector3D add(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() + vectorB.getX(), vectorA.getY() + vectorB.getY(), vectorA.getZ() + vectorB.getZ());
    }

    /**
     * subtract one vector to another
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static Vector3D substract(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() - vectorB.getX(), vectorA.getY() - vectorB.getY(), vectorA.getZ() - vectorB.getZ());
    }

    /**
     * Normalize one vector
     * @param vectorA
     * @return
     */
    public static Vector3D normalize(Vector3D vectorA){
        double mag = Vector3D.magnitude(vectorA);
        return new Vector3D(vectorA.getX() / mag, vectorA.getY() / mag, vectorA.getZ() / mag);
    }

    /**
     * Multiplicate a vector with an scalar
     * @param vectorA
     * @param scalar
     * @return
     */
    public static Vector3D scalarMultiplication(Vector3D vectorA, double scalar){
        return new Vector3D(vectorA.getX() * scalar, vectorA.getY() * scalar, vectorA.getZ() * scalar);
    }

    /**
     * function to print vectors and not their memory position
     * @return
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }

    /**
     * clone a vector
     * @return
     */
    public Vector3D clone(){
        return new Vector3D(getX(), getY(), getZ());
    }

    /**
     * return a vector with a zero in all of its positions
     * @return
     */
    public static Vector3D ZERO(){
        return ZERO.clone();
    }
}
