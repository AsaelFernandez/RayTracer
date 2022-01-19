/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer.lights;

import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public class DirectionalLight extends Light {
    private Vector3D direction;
    /** Getters, setters and constructors of the class
     */
    public DirectionalLight(Vector3D position, Vector3D direction, Material material, double intensity){
        super(position, material, intensity);
        setDirection(Vector3D.normalize(direction));
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }

    /**
     * calculate de dot product for the light diffuse
     * @param intersection
     * @return
     */
    @Override
    public float getNDotL(Intersection intersection) {
        return (float)Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(), -1.0)), 0.0);
    }
}
