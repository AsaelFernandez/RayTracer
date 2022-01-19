/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer;

import up.edu.isgc.raytracer.objects.Object3D;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class Intersection {
    /**
     * Getters, setters and constructors of the class
     */
    private double distance;
    private Vector3D normal;
    private Vector3D position;
    private Object3D object;

    /**
     *
     * @param position
     * @param distance
     * @param normal
     * @param object
     */
    public Intersection(Vector3D position, double distance, Vector3D normal, Object3D object) {
        setPosition(position);
        setDistance(distance);
        setNormal(normal);
        setObject(object);
    }

    /**
     *
     * @return
     */
    public double getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public Vector3D getNormal() {
        return normal;
    }

    /**
     *
     * @param normal
     */
    public void setNormal(Vector3D normal) {
        this.normal = normal;
    }

    /**
     *
     * @return
     */
    public Vector3D getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(Vector3D position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public Object3D getObject() {
        return object;
    }

    /**
     *
     * @param object
     */
    public void setObject(Object3D object) {
        this.object = object;
    }
}
