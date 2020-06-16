package customers.project.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Dashboard {
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
private List<MesureWidget> widgets=new ArrayList<MesureWidget>();
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
private List<MesureGraphe> graphes=new ArrayList<MesureGraphe>();
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
private List<MesureComposition> compositions=new ArrayList<MesureComposition>();
public List<MesureWidget> getWidgets() {
	return widgets;
}
public void setWidgets(List<MesureWidget> widgets) {
	this.widgets = widgets;
}
public List<MesureGraphe> getGraphes() {
	return graphes;
}
public void setGraphes(List<MesureGraphe> graphes) {
	this.graphes = graphes;
}
public List<MesureComposition> getCompositions() {
	return compositions;
}
public void setCompositions(List<MesureComposition> compositions) {
	this.compositions = compositions;
}
}
