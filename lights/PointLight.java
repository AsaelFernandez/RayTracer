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
public class PointLight extends Light {
    /**
     * constructor
     * @param position
     * @param material
     * @param intensity
     */
    public PointLight(Vector3D position, Material material, double intensity) {
        super(position, material, intensity);
    }
    /**
     * calculate de dot product for the light diffuse
     * @param intersection
     * @return
     */
    @Override
    public float getNDotL(Intersection intersection) {
        return (float) Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.normalize(Vector3D.substract(getPosition(), intersection.getPosition()))), 0.0);
    }
}
