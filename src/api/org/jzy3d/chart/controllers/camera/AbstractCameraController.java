package org.jzy3d.chart.controllers.camera;

import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.AbstractController;
import org.jzy3d.chart.controllers.ControllerType;
import org.jzy3d.maths.Coord2d;


public abstract class AbstractCameraController extends AbstractController{
	public AbstractCameraController() {
        super();
    }

    public AbstractCameraController(Chart chart) {
        super(chart);
    }

    public static boolean DEFAULT_UPDATE_VIEW = false;
    
    protected void rotate(final Coord2d move){
        rotate(move, DEFAULT_UPDATE_VIEW);
    }
    
	protected void rotate(final Coord2d move, boolean updateView){
		for(Chart c: targets)
			c.getView().rotate(move, DEFAULT_UPDATE_VIEW);
		fireControllerEvent(ControllerType.ROTATE, move);
	}
	
    protected void shift(final float factor){
        shift(factor, DEFAULT_UPDATE_VIEW);
    }	
    
	protected void shift(final float factor, boolean updateView){
		for(Chart c: targets)
			c.getView().shift(factor, updateView);
		fireControllerEvent(ControllerType.SHIFT, factor);
	}
	
	protected void zoomX(final float factor){
        zoomX(factor, DEFAULT_UPDATE_VIEW);
    }   
    
	protected void zoomX(final float factor, boolean updateView){
        for(Chart c: targets)
            c.getView().zoomX(factor, updateView);
        fireControllerEvent(ControllerType.ZOOM, factor);
    }
	
	protected void zoomY(final float factor){
        zoomY(factor, DEFAULT_UPDATE_VIEW);
    }   
    
    protected void zoomY(final float factor, boolean updateView){
        for(Chart c: targets)
            c.getView().zoomY(factor, updateView);
        fireControllerEvent(ControllerType.ZOOM, factor);
    }
    
    protected void zoomZ(final float factor){
        zoomZ(factor, DEFAULT_UPDATE_VIEW);
    }   
    
    protected void zoomZ(final float factor, boolean updateView){
        for(Chart c: targets)
            c.getView().zoomZ(factor, updateView);
        fireControllerEvent(ControllerType.ZOOM, factor);
    }
}