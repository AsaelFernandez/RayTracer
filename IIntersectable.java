/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */

public interface IIntersectable {
    public abstract Intersection getIntersection(Ray ray);
}
