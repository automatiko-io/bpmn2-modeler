package org.eclipse.bpmn2.modeler.examples.modelreader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.RootElement;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.bpmn2.impl.SequenceFlowImpl;
import org.eclipse.bpmn2.util.Bpmn2ResourceFactoryImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class ModelReader {

	public static void main(String[] args) throws IOException {
		URI uri = URI.createURI("SampleProcess.bpmn");
		Bpmn2ResourceFactoryImpl resFactory = new Bpmn2ResourceFactoryImpl();
		Resource resource = resFactory.createResource(uri);
		
		// We need this option because all object references in the file are "by ID"
		// instead of the document reference "URI#fragment" form.
		HashMap<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		
		// Load the resource
		resource.load(options);
		
		// This is the root element of the XML document
		Definitions d = (Definitions) resource.getContents().get(0).eContents().get(0);

		// Print all elements contained in all Processes found
		List<RootElement> rootElements = d.getRootElements();
		for (RootElement re : rootElements) {
			if (re instanceof org.eclipse.bpmn2.Process) {
				org.eclipse.bpmn2.Process process = (org.eclipse.bpmn2.Process) re;
				System.out.println("Process: name="+process.getName()+" ID="+process.getId());
				for (FlowElement fe : process.getFlowElements()) {
					if (fe instanceof SequenceFlowImpl) {
						SequenceFlow sf = ((SequenceFlow) fe);
						if (sf != null) {
							String source = "";
							String target = "";
							if (sf.getSourceRef() != null)
								source = sf.getSourceRef().getId();
							if (sf.getTargetRef() != null)
								target = sf.getTargetRef().getId();
							System.out.println("Sequence Flow: " + source + " -> " + target);
						}
					}
					else {
						System.out.println(fe.eClass().getName()+": name="+fe.getName()+" ID="+fe.getId());
					}
				}

			}
		}
	}
}
