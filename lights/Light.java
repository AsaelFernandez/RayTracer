/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer.lights;

import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Ray;
import up.edu.isgc.raytracer.Vector3D;
import up.edu.isgc.raytracer.objects.Object3D;

import java.awt.*;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */
public abstract class Light extends Object3D {
    private double intensity;
    /** Getters, setters and constructors of the class
     */
    public Light(Vector3D position, Material material, double intensity){
        super(position, material);
        setIntensity(intensity);
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public abstract float getNDotL(Intersection intersection);

    public Intersection getIntersection(Ray ray){
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}
