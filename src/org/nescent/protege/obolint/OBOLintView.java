package org.nescent.protege.obolint;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import org.protege.editor.owl.ui.framelist.OWLFrameList;
import org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent;
import org.semanticweb.owlapi.model.OWLOntology;

@SuppressWarnings("serial")
public class OBOLintView extends AbstractActiveOntologyViewComponent {

	private OWLFrameList<OWLOntology> oboLintList;

	@Override
	public void initialiseOntologyView() {
		final OBOlintFrame frame = new OBOlintFrame(this.getOWLEditorKit());
		this.oboLintList = new OWLFrameList<OWLOntology>(this.getOWLEditorKit(), frame);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(this.oboLintList));
	}

	@Override
	protected void disposeOntologyView() {
		this.oboLintList.dispose();
	}

	@Override
	protected void updateView(OWLOntology ontology) throws Exception {
		this.oboLintList.getFrame().setRootObject(ontology);
	}

}
