package business;

import bll.EditorBO;
import dal.AbstractDAOEditorFactory;
import dal.FacadeDAO;
import dal.IEditorDBDAO;
import dal.IFacadeDAO;

public class TransliterateCommand implements ICommand {
    private int pageId;
    private String text;
    private EditorBO editorBO;

    public TransliterateCommand(int pageId, String text) {
        this.pageId = pageId;
        this.text = text;
        IEditorDBDAO editorDAO = AbstractDAOEditorFactory.getInstance().createEditorDAO();
        IFacadeDAO facadeDAO = new FacadeDAO(editorDAO);
        this.editorBO = new EditorBO(facadeDAO);
    }

    @Override
    public boolean execute() {
        String result = editorBO.transliterate(pageId, text);
        return result != null;
    }
}
