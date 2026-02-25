package business;

import bll.EditorBO;
import dal.AbstractDAOEditorFactory;
import dal.FacadeDAO;
import dal.IEditorDBDAO;
import dal.IFacadeDAO;

public class SaveCommand implements ICommand {
    private String fileName;
    private String content;
    private EditorBO editorBO;

    public SaveCommand(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        IEditorDBDAO editorDAO = AbstractDAOEditorFactory.getInstance().createEditorDAO();
        IFacadeDAO facadeDAO = new FacadeDAO(editorDAO);
        this.editorBO = new EditorBO(facadeDAO);
    }

    @Override
    public boolean execute() {
        return editorBO.createFile(fileName, content);
    }
}
