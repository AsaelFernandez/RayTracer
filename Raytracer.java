/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer;

import up.edu.isgc.raytracer.Materials.Lambert;
import up.edu.isgc.raytracer.Materials.Material;
import up.edu.isgc.raytracer.Materials.Reflective;
import up.edu.isgc.raytracer.Materials.Refractive;
import up.edu.isgc.raytracer.lights.*;
import up.edu.isgc.raytracer.objects.*;
import up.edu.isgc.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Asael Fernandez
 * @coauthor Jafet Rodríguez
 */


public class Raytracer {
    /**
     *
     * @method Main create new scene and start the image creation
     */

    public static void main(String[] args) {
        System.out.println(new Date());
        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 1200, 1200, 8.2f, 50f));
        scene01.addLight(new PointLight(new Vector3D(0,10,1), new Lambert(Color.WHITE,0,0),30));
        scene01.addLight(new PointLight(new Vector3D(-7,10,-5), new Lambert(Color.WHITE,0,0),30));
        scene01.addLight(new PointLight(new Vector3D(0,10,-7), new Lambert(Color.WHITE,0,0),30));
        /*scene01.addObject(OBJReader.GetPolygon("ObjFiles/Pillar.obj", new Vector3D(-5, -1, 10f), new Lambert(new Color(124, 0, 173),0,1),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/SmallTeapot.obj", new Vector3D(6, 1.5, 14f), new Reflective(new Color(212,175,55),0.1,5),new float[]{1,1,1},new int[]{-1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/SmallTeapot.obj", new Vector3D(-5, 1.5, 10f), new Reflective(new Color(212,175,55),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/Pillar.obj", new Vector3D(6, -1, 14f), new Lambert(new Color(124, 0, 173),0,1),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(new Sphere(new Vector3D(0f, -1f, 10), 1f, new Lambert(Color.ORANGE,0,1)));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/Wall.obj", new Vector3D(0, -1.15, 2), new Refractive(new Color(151, 195, 192),0.1,5,5),new float[]{.08f,.01f,.1f},new int[]{1,1,1}));
        scene01.addObject(new Sphere(new Vector3D(2, -1.f, 12), .75f, new Reflective(new Color(192, 192, 192),0.1,5)));
        scene01.addObject(new Sphere(new Vector3D(-2, -1.f, 12), .75f, new Reflective(new Color(192, 192, 192),0.1,5)));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/AirPlane.obj", new Vector3D(3, 3, 12), new Reflective(new Color(107, 175, 203),0.1,5),new float[]{1,1,1},new int[]{-1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/AirPlane.obj", new Vector3D(-2.2, 4, 12), new Reflective(new Color(107, 175, 203),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/AirPlane.obj", new Vector3D(0, 1, 8), new Reflective(new Color(107, 175, 203),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(new Sphere(new Vector3D(0.3f, 3.5, 10), 1.5f, new Refractive(new Color(151, 195, 192),0.1,5,1.5)));*/
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeQuad.obj",new Vector3D(0, 0f, 6), new Reflective(new Color(203, 9, 0),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeR1.obj",new Vector3D(4, -1f, 5), new Reflective(new Color(21, 2, 203),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeR2.obj",new Vector3D(-3, 2f, 10), new Reflective(new Color(9, 203, 0),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeR3.obj",new Vector3D(1, 3f, 6.5), new Reflective(new Color(255, 251, 23),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeR4.obj",new Vector3D(.5, -3f, 2), new Reflective(new Color(203, 11, 171),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/CubeR5.obj",new Vector3D(-2.5, -1f, 3), new Reflective(new Color(203, 125, 34),0.1,5),new float[]{1,1,1},new int[]{1,1,1}));
        scene01.addObject(new Sphere(new Vector3D(1.3, -1.f, 3), 1.75f, new Refractive(new Color(134, 142, 255),0.1,5,.8)));
        scene01.addObject(OBJReader.GetPolygon("ObjFiles/Mono.obj",new Vector3D(2.5, 2f, 1.5), new Reflective(new Color(203, 114, 43),0.1,5),new float[]{.8f,.8f,.8f},new int[]{1,1,1}));

        scene01.addObject(OBJReader.GetPolygon("ObjFiles/Ground.obj", new Vector3D(0f, -4.0f, 0f ), new Lambert(new Color(193, 255, 250),0,1),new float[]{1,1,1},new int[]{-1,-1,1}));

        BufferedImage image = raytrace(scene01);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ioe) {
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    /**
     *
     * @param scene Creates the image whith the  scene values
     * @return
     */
    public static BufferedImage raytrace(Scene scene) {
        ExecutorService executorService= Executors.newFixedThreadPool(8);
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                Runnable runnable= createImage(i,j,mainCamera, ray, objects, nearFarPlanes, lights, image);
                executorService.execute(runnable);
            }
        }

        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(4, TimeUnit.HOURS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(!executorService.isTerminated()){
                System.err.println("Cancel non-finished");
            }
        }
        executorService.shutdownNow();


        return image;
    }

    /**
     * Runnable function to implement parallelism
     * Calculate al intersections and color to create the  image
     * @param i
     * @param j
     * @param mainCamera
     * @param ray
     * @param objects
     * @param nearFarPlanes
     * @param lights
     * @param image
     * @return
     */
    private static Runnable createImage(int i,int j,Camera mainCamera,Ray ray,ArrayList<Object3D> objects,float[] nearFarPlanes,ArrayList<Light> lights,BufferedImage image){
        Runnable aRunnable= new Runnable() {
            @Override
            public void run() {

                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = rayCast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    pixelColor = Color.BLACK;
                    for (Light light : lights) {

                        float[] newObjectColors = Material.calculateColors(light, closestIntersection, mainCamera);

                        if (closestIntersection.getObject().getMaterial() instanceof Reflective) {

                            Intersection resultIntersection = getReflection(closestIntersection,  objects, mainCamera);
                            Light light1 = null;
                            Light light2 = null;

                            if (resultIntersection != null) {

                                if (light instanceof PointLight) {
                                    light1 = new PointLight(light.getPosition(), new Lambert(closestIntersection.getObject().getMaterial().getColor(),0 ,  0),light.getIntensity());
                                } else if (light instanceof DirectionalLight) {
                                    light1 = new DirectionalLight(light.getPosition(), ((DirectionalLight) light).getDirection(), new Lambert(closestIntersection.getObject().getMaterial().getColor(),0,  0),light.getIntensity());
                                }

                                Intersection reflectedObject = null;
                                if (resultIntersection.getObject().getMaterial() instanceof Reflective) {
                                    reflectedObject = getReflection(resultIntersection, objects, mainCamera);
                                } else if (resultIntersection.getObject().getMaterial() instanceof Refractive) {
                                    reflectedObject = getRefraction(resultIntersection,  objects, mainCamera);
                                }

                                if (reflectedObject != null) {
                                    if (light instanceof PointLight) {
                                        light2 = new PointLight(light.getPosition(), new Lambert(resultIntersection.getObject().getMaterial().getColor(), 0,  0),light.getIntensity());
                                    } else if (light instanceof DirectionalLight) {
                                        light2 = new DirectionalLight(light.getPosition(), ((DirectionalLight) light).getDirection(), new Lambert(resultIntersection.getObject().getMaterial().getColor(), 0,  0),light.getIntensity());
                                    }
                                    newObjectColors = Material.calculateColors(light2, reflectedObject, mainCamera);


                                    Ray shadow= new Ray(closestIntersection.getPosition(),light.getPosition());
                                    Intersection shadowIntersection= rayCast(shadow,objects,closestIntersection.getObject(),new float[]{cameraZ+nearFarPlanes[0], cameraZ+nearFarPlanes[1]});
                                    Color diffuse = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                                    if(shadowIntersection!=null) {
                                        diffuse=Color.black;
                                    }

                                    pixelColor = addColor(pixelColor, diffuse);

                                } else {
                                    newObjectColors = Material.calculateColors(light1, resultIntersection, mainCamera);


                                    Ray shadow= new Ray(closestIntersection.getPosition(),light.getPosition());
                                    Intersection shadowIntersection= rayCast(shadow,objects,closestIntersection.getObject(),new float[]{cameraZ+nearFarPlanes[0], cameraZ+nearFarPlanes[1]});
                                    Color diffuse = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                                    if(shadowIntersection!=null) {
                                        diffuse=Color.black;
                                    }

                                    pixelColor = addColor(pixelColor, diffuse);

                                }

                            }

                            Color newCol = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                            pixelColor = addColor(pixelColor, newCol);

                        } else if (closestIntersection.getObject().getMaterial() instanceof Refractive) { // REFRACTION

                            Intersection resultIntersection = getRefraction(closestIntersection,  objects,mainCamera);
                            Light light1 = null;
                            Light light2 = null;

                            if (resultIntersection != null) {

                                if (light instanceof PointLight) {
                                    light1 = new PointLight(light.getPosition(), new Lambert(closestIntersection.getObject().getMaterial().getColor(), 0,0),light.getIntensity());
                                } else if (light instanceof DirectionalLight) {
                                    light1 = new DirectionalLight(light.getPosition(), ((DirectionalLight) light).getDirection(), new Lambert(closestIntersection.getObject().getMaterial().getColor(), 0,  0),light.getIntensity());
                                }

                                Intersection reflectedObject = null;
                                if (resultIntersection.getObject().getMaterial() instanceof Reflective) {
                                    reflectedObject = getReflection(resultIntersection,  objects, mainCamera);
                                } else if (resultIntersection.getObject().getMaterial() instanceof Refractive) {
                                    reflectedObject = getRefraction(resultIntersection,  objects, mainCamera);
                                }

                                if (reflectedObject != null) {
                                    if (light instanceof PointLight) {
                                        light2 = new PointLight(light.getPosition(), new Lambert(resultIntersection.getObject().getMaterial().getColor(), 0,  0),light.getIntensity());
                                    } else if (light instanceof DirectionalLight) {
                                        light2 = new DirectionalLight(light.getPosition(), ((DirectionalLight) light).getDirection(), new Lambert(resultIntersection.getObject().getMaterial().getColor(), 0,  0),light.getIntensity());
                                    }
                                    newObjectColors = Material.calculateColors(light2, reflectedObject, mainCamera);

                                    Ray shadow= new Ray(closestIntersection.getPosition(),light.getPosition());
                                    Intersection shadowIntersection= rayCast(shadow,objects,closestIntersection.getObject(),new float[]{cameraZ+nearFarPlanes[0], cameraZ+nearFarPlanes[1]});
                                    Color diffuse = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                                    if(shadowIntersection!=null) {
                                        diffuse=Color.black;
                                    }

                                    pixelColor = addColor(pixelColor, diffuse);

                                } else {
                                    newObjectColors = Material.calculateColors(light1, resultIntersection, mainCamera);

                                    Ray shadow= new Ray(closestIntersection.getPosition(),light.getPosition());
                                    Intersection shadowIntersection= rayCast(shadow,objects,closestIntersection.getObject(),new float[]{cameraZ+nearFarPlanes[0], cameraZ+nearFarPlanes[1]});
                                    Color diffuse = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                                    if(shadowIntersection!=null) {
                                        diffuse=Color.black;
                                    }

                                    pixelColor = addColor(pixelColor, diffuse);
                                }
                            }
                            Color newCol = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                            pixelColor = addColor(pixelColor, newCol);

                        }
                        Ray shadow= new Ray(closestIntersection.getPosition(),light.getPosition());
                        Intersection shadowIntersection= rayCast(shadow,objects,closestIntersection.getObject(),new float[]{cameraZ+nearFarPlanes[0], cameraZ+nearFarPlanes[1]});
                        Color diffuse = new Color(clamp(newObjectColors[0], 0, 1), clamp(newObjectColors[1], 0, 1), clamp(newObjectColors[2], 0, 1));
                        if(shadowIntersection!=null) {
                            diffuse=Color.black;
                        }
                        pixelColor = addColor(pixelColor, diffuse);
                    }
                }
                setColor(i, j, pixelColor,image);
            }
        };
        return aRunnable;
    }

    /**
     * Method to synchronize threads in parallelism
     * @param i
     * @param j
     * @param pixelColor
     * @param image
     */
    private static synchronized void setColor(int i, int j, Color pixelColor, BufferedImage image){
        image.setRGB(i,j,pixelColor.getRGB());
    }

    /**
     * Makes al calculations to get the intersection where the refraction light-ray will reach
     * it returns an Intersection
     * @param closestIntersection
     * @param objects
     * @param mainCamera
     * @return
     */
    public static Intersection getRefraction(Intersection closestIntersection,  ArrayList<Object3D> objects, Camera mainCamera) {

        Vector3D intersectionNormal = closestIntersection.getNormal();
        Vector3D intersectionNewPosition;
        Intersection finalIntersection;
        double IndexOfRefraction =((Refractive) closestIntersection.getObject().getMaterial()).getObjectRefraction();

        if (closestIntersection.getObject() instanceof Sphere) {
            double avoidAcne = 1.5;
            Vector3D bias = Vector3D.scalarMultiplication(intersectionNormal, avoidAcne);
            double fresnel = Math.pow((IndexOfRefraction-1),2) / Math.pow((IndexOfRefraction+1),2);
            if (fresnel > 0) {
                intersectionNewPosition = Vector3D.add(closestIntersection.getPosition(), bias);
            } else {
                intersectionNewPosition = Vector3D.substract(closestIntersection.getPosition(), bias);
            }
        } else {
            intersectionNewPosition = closestIntersection.getPosition();
        }

        Vector3D viewerRay = Vector3D.substract(intersectionNewPosition, mainCamera.getPosition());

        double iDotN = Vector3D.dotProduct(viewerRay, intersectionNormal);
        Vector3D reflected = null;

        double angleViewer = 1;
        double angleReflected = IndexOfRefraction;
        double cosAngleViewer = clamp(-1.0f, 1.0f, (float) iDotN);

        Vector3D normalCloned = intersectionNormal.clone();

        if (cosAngleViewer < 0) {
            cosAngleViewer = -cosAngleViewer;
        } else {
            double aux = angleViewer;
            angleViewer = angleReflected;
            angleReflected = aux;
            normalCloned = Vector3D.scalarMultiplication(intersectionNormal, -1.0);
        }

        double finalAngle = angleViewer / angleReflected;
        double finalConstant = 1 - Math.pow(finalAngle, 2) * (1 - Math.pow(cosAngleViewer, 2));

        if (finalConstant <= 0) {
            reflected = Vector3D.ZERO();
        } else {
            reflected = Vector3D.add(Vector3D.scalarMultiplication(viewerRay, finalAngle),
                    Vector3D.scalarMultiplication(normalCloned, ((finalAngle * cosAngleViewer) - Math.sqrt(finalConstant))));
        }

        Vector3D refractedVector = reflected;

        Ray refractedRay = new Ray(intersectionNewPosition, refractedVector);
        Intersection refractedIntersection = rayCast(refractedRay, objects, closestIntersection.getObject(), null);

        finalIntersection = refractedIntersection;

        return finalIntersection;
    }


    /**
     * Makes al calculations to get the intersection where the reflection light-ray will reach
     * it returns an Intersection
     * @param closestIntersection
     * @param objects
     * @param mainCamera
     * @return
     */
    public static Intersection getReflection(Intersection closestIntersection,  ArrayList<Object3D> objects, Camera mainCamera) {
        Vector3D intersectionNormal = closestIntersection.getNormal();
        Vector3D intersectionViewer = Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
        double nDotL= Vector3D.dotProduct(intersectionNormal,intersectionViewer);
        Vector3D doubleNormal= Vector3D.scalarMultiplication(intersectionNormal,-2);
        Vector3D nDotLTimesNormal= Vector3D.scalarMultiplication(doubleNormal,nDotL);
        Vector3D reflection = Vector3D.add(nDotLTimesNormal,intersectionViewer);

        Ray reflectionRay = new Ray(closestIntersection.getPosition(), reflection);
        Intersection reflectedIntersection = rayCast(reflectionRay, objects, closestIntersection.getObject(), null);

        return reflectedIntersection;
    }

    /**
     * It returns the value receibed but with a max and min restriction
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * Add two different colors respecting the RGB percentages
     * returns Color
     * @param original
     * @param otherColor
     * @return
     */
    public static Color addColor(Color original, Color otherColor){
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * Calculate the intersection from a pixel to objects
     * returns Intersection
     * @param ray
     * @param objects
     * @param caster
     * @param clippingPlanes
     * @return
     */
    public static Intersection rayCast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }
}
