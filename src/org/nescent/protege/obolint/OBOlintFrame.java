package org.nescent.protege.obolint;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.frame.AbstractOWLFrame;
import org.semanticweb.owlapi.model.OWLOntology;

class OBOlintFrame extends AbstractOWLFrame<OWLOntology> {

	public OBOlintFrame(OWLEditorKit owlEditorKit) {
		super(owlEditorKit.getModelManager().getOWLOntologyManager());
		addSection(new OBOlintFrameSection(owlEditorKit, this));
	}
}