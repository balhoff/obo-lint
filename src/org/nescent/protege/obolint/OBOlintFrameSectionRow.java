package org.nescent.protege.obolint;

import java.util.Arrays;
import java.util.List;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.editor.OWLObjectEditor;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSectionRow;
import org.protege.editor.owl.ui.frame.OWLFrameSection;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

class OBOlintFrameSectionRow extends AbstractOWLFrameSectionRow<OWLOntology, OWLAxiom, OWLAxiom> {

	protected OBOlintFrameSectionRow(OWLEditorKit owlEditorKit, OWLFrameSection<OWLOntology, OWLAxiom, OWLAxiom> section, OWLOntology ontology, OWLOntology rootObject, OWLAxiom axiom) {
		super(owlEditorKit, section, ontology, rootObject, axiom);
	}

	protected OWLAxiom createAxiom(OWLAxiom editedObject) {
		return editedObject;
	}

	protected OWLObjectEditor<OWLAxiom> getObjectEditor() {
		return null;
	}

	public List<OWLAxiom> getManipulatableObjects() {
		return Arrays.asList(axiom);
	}

	@Override
	public boolean isEditable() {
		return false;
	}

}