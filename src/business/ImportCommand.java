package business;

import bll.EditorBO;
import dal.AbstractDAOEditorFactory;
import dal.FacadeDAO;
import dal.IEditorDBDAO;
import dal.IFacadeDAO;
import java.io.File;

public class ImportCommand implements ICommand {
    private String filePath;
    private EditorBO editorBO;

    public ImportCommand(String filePath) {
        this.filePath = filePath;
        // Basic initialization for testing purposes
        IEditorDBDAO editorDAO = AbstractDAOEditorFactory.getInstance().createEditorDAO();
        IFacadeDAO facadeDAO = new FacadeDAO(editorDAO);
        this.editorBO = new EditorBO(facadeDAO);
    }

    public ImportCommand(String filePath, EditorBO editorBO) {
        this.filePath = filePath;
        this.editorBO = editorBO;
    }

    @Override
    public boolean execute() {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }
        return editorBO.importTextFiles(file, file.getName());
    }
}
