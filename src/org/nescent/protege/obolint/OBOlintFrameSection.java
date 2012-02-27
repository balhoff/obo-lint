package org.nescent.protege.obolint;

import java.util.Comparator;

import org.obolibrary.obo2owl.Owl2Obo;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.editor.OWLObjectEditor;
import org.protege.editor.owl.ui.frame.AbstractOWLFrameSection;
import org.protege.editor.owl.ui.frame.OWLFrame;
import org.protege.editor.owl.ui.frame.OWLFrameSectionRow;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

class OBOlintFrameSection extends AbstractOWLFrameSection<OWLOntology, OWLAxiom, OWLAxiom> {

	protected OBOlintFrameSection(OWLEditorKit editorKit, OWLFrame<? extends OWLOntology> frame) {
		super(editorKit, "Untranslatable axioms", "Untranslatable axiom", frame);
	}

	@Override
	public Comparator<OWLFrameSectionRow<OWLOntology, OWLAxiom, OWLAxiom>> getRowComparator() {
		return null;
	}

	@Override
	protected void clear() {	
	}

	@Override
	protected OWLAxiom createAxiom(OWLAxiom axiom) {
		return null;
	}

	@Override
	public OWLObjectEditor<OWLAxiom> getObjectEditor() {
		return null;
	}

	@Override
	protected void refill(OWLOntology ontology) {
		final Owl2Obo owl2obo = new Owl2Obo();
		try {
			owl2obo.convert(ontology);
		} catch (OWLOntologyCreationException e) {
			LOGGER.error("Error when converting ontology to OBO", e);
		}
		for (OWLAxiom axiom : owl2obo.getUntranslatableAxioms()) {
			addRow(new OBOlintFrameSectionRow(this.getOWLEditorKit(), this, ontology, ontology, axiom));
		}
	}

	@Override
	public boolean canAdd() {
		return false;
	}

}