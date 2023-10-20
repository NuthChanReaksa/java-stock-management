package Stock;

import Stock.Stock;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;

public class RenderTable {
    public static void renderMenu(List<String> menu){
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);

        table.setColumnWidth(0 ,5,6);
        table.setColumnWidth(1,25,45);
        table.addCell("No",cellStyle);
        table.addCell("Operation",cellStyle);

        for(int i = 0; i < menu.size() ; i++){
            table.addCell((i+1)+"",cellStyle);
            table.addCell(menu.get(i),cellStyle);
        }

        System.out.println(table.render());
    }
}


