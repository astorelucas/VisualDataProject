package lucastorie;

import processing.core.PApplet;
import processing.core.PFont;
import java.util.ArrayList;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.mapdisplay.MapDisplayFactory;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import de.fhpotsdam.unfolding.providers.EsriProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.Yahoo;

@SuppressWarnings("serial")
public class HelloMap extends PApplet {

    UnfoldingMap map;
    SimplePointMarker posMarker;
    SimplePointMarker hitMarker = null;
     //ImageMarker hitMarker = null;
    
    static ArrayList<String> tweets = new ArrayList();
    
    static ArrayList<Float> latitude = new ArrayList();
    
    static ArrayList<Float> longitude = new ArrayList();
    
    static int mapChooser;
     
  public static void createMapData(ArrayList<String> in) {
   	
	//final int tamTweets = in.size();
		 
	 
	//  System.out.println(tweets.length);
	  
	  
    	for(int i=1; i< in.size() ; i++) {
    	
    	if(in.get(i).indexOf("|")>-1) {
    			
    			int posLat = in.get(i).indexOf("|"); //pega a posição que aparece "|"
    			int posLong = in.get(i).lastIndexOf("|"); //pega a posição que aparece "|"
 
    			latitude.add(Float.parseFloat(in.get(i).substring(posLat+1,posLong)));
    			
    			longitude.add(Float.parseFloat(in.get(i).substring(posLong+1)));
    			
       			tweets.add(in.get(i).substring(0,posLat));
    			
    			//System.out.println(tweets.get(i));
    			
    		}
    		
    		
    	}
    	
  }
  

    @SuppressWarnings("deprecation")
	public void setup() {
    	
    	size(1024, 768, OPENGL);
    	frame.resize(1024, 768);
    	frame.setResizable(true);
        PFont font = createFont("serif-bold", 20);
      
        textFont(font);
        
        if(mapChooser == -1 || mapChooser == 0 ) {
        	map = new UnfoldingMap(this, new EsriProvider.DeLorme());
        }else if(mapChooser == 1) {
        	map = new UnfoldingMap(this, new Microsoft.AerialProvider());
        }else if(mapChooser == 2) {
        	map = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        }else if(mapChooser == 3) {
        	map = new UnfoldingMap(this, new  Yahoo.RoadProvider());
        }
       
        /*
        outros mapas
        OpenStreetMap.OpenStreetMapProvider();
        OpenStreetMap.CloudmadeProvider(API KEY, STYLE ID);
        StamenMapProvider.Toner();
        Google.GoogleMapProvider();
        Google.GoogleTerrainProvider();
        Microsoft.RoadProvider();
        Microsoft.AerialProvider();
        Yahoo.RoadProvider();
        Yahoo.HybridProvider();
        */
  
        
        double meanLatitude = 0;
        double meanLongitude = 0;
        for (int i = 0; i < latitude.size(); i++) {
        	meanLatitude += latitude.get(i);
        	meanLongitude += longitude.get(i);
        }
        meanLatitude = meanLatitude/latitude.size();
        meanLongitude = meanLongitude/latitude.size();
        
        double maxDistance = 0;
        for (int i = 0; i < latitude.size(); i++) {
        	double distLat = Math.abs(meanLatitude - latitude.get(i));
        	double distLon = Math.abs(meanLongitude -  longitude.get(i));
        	double maxLatLon = distLat > distLon? distLat : distLon;
        	maxDistance = maxDistance > maxLatLon? maxDistance : maxLatLon;
        }
        //centro do mapa
        map.zoomAndPanTo(Math.round(180/Math.round(maxDistance+1)), new Location(meanLatitude, meanLongitude));
       
        for (int i = 0; i < latitude.size(); i++) {
        	Location local = new Location(latitude.get(i),longitude.get(i));
        	posMarker = new SimplePointMarker(local);
        	posMarker.setRadius(20);
        	posMarker.setColor(color(0, 0, 255, 75));
        	posMarker.setId("" + i);
        	map.addMarkers(posMarker);
        }
        
        
        //Usar figura como icone
        //ImageMarker markerBlue = new ImageMarker(berlinLocation,loadImage("icons8-marcador-40_blue.png"));
        //ImageMarker markerRed = new ImageMarker(berlinLocation,loadImage("icons8-marcador-40_red.png"));
        //map.addMarkers(markerBlue);
        
        map.setTweening(true);
        
        MapUtils.createDefaultEventDispatcher(this, map);      
    }

    
    
    public void draw() {
    	sketchFullScreen();
    	background(255);

        map.draw();
      
                
        //escreve o texto se o mouse estiver em cima
        if ((hitMarker != null) && (hitMarker.isSelected())){
        	ScreenPosition HitPos = hitMarker.getScreenPosition(map);
        	int index = Integer.parseInt(hitMarker.getId());
        	//fill(color(0, 0, 0, 100));//cor do texto
        	fill(0);
        	text(tweets.get(index), HitPos.x - textWidth(tweets.get(index)) / 2, HitPos.y + 4);
        }
        	
    }
    

    
    public void mouseMoved() {
        hitMarker = (SimplePointMarker) map.getFirstHitMarker(mouseX, mouseY);
        if ((hitMarker != null) && (hitMarker.isInside(map,mouseX, mouseY))){
        //if (hitMarker != null) {
            // Select current marker 
        	hitMarker.setSelected(true);
            
        } else {
            // Deselect all other markers
            for (Marker marker : map.getMarkers()) {
                marker.setSelected(false);
            }
        }
    }

    
}