package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import sample.Controller;
import sample.com.doorder.door.LabelNames;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BlankOrder {

    private ActionEvent event;
    private boolean isFireproofDoor;
    private String clientName;
    private String clientPhone;
    private String clientAddress;
    private String sellerContactInfo;
    private String profitPercent;
    private String x;
    private String y;
    private String x1;
    private String y1;
    private String x2;
    private String x3;
    private String doorStructureType;
    private String doorComplexityCategory;
    private String doorImage;
    private String outerDecoration;
    private String outerColor;
    private String outerConfiguration;
    private String outerTransom;
    private String innerDecoration;
    private String innerColor;
    private String innerConfiguration;
    private String innerTransom;
    private String mainLock;
    private String secondaryLock;
    private String handle;
    private String protector;
    private String spyHole;
    private String platbank;
    private String platbandWidth;
    private String packaging;
    private String shipping;
    private String installation;
    private String comments;
    private String totalPrice;
    private String orderDate;

    public BlankOrder(ActionEvent event, boolean isFireproofDoor, String clientName, String clientPhone, String clientAddress,
                      String sellerContactInfo, String profitPercent,
                      String x, String y,
                      String x1, String y1,
                      String x2, String x3,
                      String doorStructureType, String doorComplexityCategory,
                      String doorImage,
                      String outerDecoration,
                      String outerColor,
                      String outerConfiguration,
                      String outerTransom,
                      String innerDecoration,
                      String innerColor,
                      String innerConfiguration,
                      String innerTransom,
                      String mainLock, String secondaryLock,
                      String handle, String protector, String spyHole,
                      String platbank, String platbandWidth,
                      String packaging, String shipping, String installation,
                      String comments,
                      String totalPrice, String orderDate) {
        this.event = event;
        this.isFireproofDoor = isFireproofDoor;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientAddress = clientAddress;
        this.sellerContactInfo = sellerContactInfo;
        this.profitPercent = profitPercent;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.x3 = x3;
        this.doorStructureType = doorStructureType;
        this.doorComplexityCategory = doorComplexityCategory;
        this.doorImage = doorImage;
        this.outerDecoration = outerDecoration;
        this.outerColor = outerColor;
        this.outerConfiguration = outerConfiguration;
        this.outerTransom = outerTransom;
        this.innerDecoration = innerDecoration;
        this.innerColor = innerColor;
        this.innerConfiguration = innerConfiguration;
        this.innerTransom = innerTransom;
        this.mainLock = mainLock;
        this.secondaryLock = secondaryLock;
        this.handle = handle;
        this.protector = protector;
        this.spyHole = spyHole;
        this.platbank = platbank;
        this.platbandWidth = platbandWidth;
        this.packaging = packaging;
        this.shipping = shipping;
        this.installation = installation;
        this.comments = comments;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public void createTestDocument(Controller controller) throws DocumentException, IOException {
        Document clientDocument = new Document();
        Document sellerDocument = new Document();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String orderDate = dateFormat.format(date);

        File clientFile = new File("client/client_" + orderDate + "_" + controller.getTodayOrderCount() + ".pdf");
        File sellerFile = new File("company/seller_" + orderDate + "_"  + controller.getTodayOrderCount() + ".pdf");
        PdfWriter.getInstance(clientDocument, new FileOutputStream(clientFile));
        PdfWriter.getInstance(sellerDocument, new FileOutputStream(sellerFile));

        clientDocument.open();
        sellerDocument.open();

        BaseFont times = BaseFont.createFont("resources/times.ttf", "cp1251", BaseFont.EMBEDDED);
        Paragraph p = new Paragraph("Заявка", new Font(times, 16, Font.BOLD));
        p.setAlignment(Element.ALIGN_CENTER);
        Paragraph p1;
        if (isFireproofDoor) {
            p1 = new Paragraph("на изготовление противопожарного дверного блока\n\n", new Font(times, 16, Font.BOLD));
        } else {
            p1 = new Paragraph("на изготовление металлических дверей\n\n", new Font(times, 16, Font.BOLD));
        }
        p1.setAlignment(Element.ALIGN_CENTER);
        clientDocument.add(p);
        sellerDocument.add(p);
        clientDocument.add(new Paragraph(p1));
        sellerDocument.add(new Paragraph(p1));

        PdfPTable clientTable = new PdfPTable(2);
        PdfPTable sellerTable = new PdfPTable(2);

        clientTable.setWidthPercentage(100);
        sellerTable.setWidthPercentage(100);
        clientTable.setWidths(new int[]{1, 3});
        sellerTable.setWidths(new int[]{1, 3});


        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Заказчик", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setRowspan(3);
        clientTable.addCell(cell);
        cell.setRowspan(1);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("ФИО:  " + clientName, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        cell = new PdfPCell(new Phrase(sellerContactInfo, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Телефон:  " + clientPhone, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        cell = new PdfPCell(new Phrase("Адрес:  " + clientAddress, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Конструкция дверного блока", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(doorStructureType, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Тип дверного блока и размеры", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(doorComplexityCategory, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(Image.getInstance("resources/" + doorImage),true);
//        cell.setColspan(2);
        cell.setFixedHeight(150f);
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        StringBuilder dimensions = new StringBuilder("x = " + x + " мм\n\n" + "y = " + y + " мм\n\n");
        if (x1 != null && !x1.isEmpty())
            dimensions.append("x1 = " + x1 + " мм\n\n");
        if (y1 != null && !y1.isEmpty())
            dimensions.append("y1 = " + y1 + " мм\n\n");
        if (x2 != null && !x2.isEmpty())
            dimensions.append("x2 = " + x2 + " мм\n\n");
        if (x3 != null && !x3.isEmpty())
            dimensions.append("x3 = " + x3 + " мм\n\n");

        cell = new PdfPCell(new Phrase(dimensions.toString(), new Font(times, 12)));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);


        cell = new PdfPCell(new Phrase("Наружная отделка", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        StringBuilder oDecoration = new StringBuilder("Тип: " + outerDecoration + "\n");
        if (outerColor != null && !outerColor.isEmpty())
            oDecoration.append("Цвет: " + outerColor + "\n");
        if (outerConfiguration != null && !outerConfiguration.isEmpty())
            oDecoration.append("Конфигурация: " + outerConfiguration + "\n");
        if (outerTransom != null && !outerTransom.isEmpty())
            oDecoration.append("Фрамуга: " + outerTransom + "\n");

        cell = new PdfPCell(new Phrase(oDecoration.toString(), new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Внутренняя отделка", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        StringBuilder iDecoration = new StringBuilder("Тип: " + innerDecoration + "\n");
        if (innerColor != null && !innerColor.isEmpty())
            iDecoration.append("Цвет: " + innerColor + "\n");
        if (innerConfiguration != null && !innerConfiguration.isEmpty())
            iDecoration.append("Конфигурация: " + innerConfiguration + "\n");
        if (innerTransom != null && !innerTransom.isEmpty())
            iDecoration.append("Фрамуга: " + innerTransom + "\n");
        cell = new PdfPCell(new Phrase(iDecoration.toString(), new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Замок основной", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(mainLock, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        if (!isFireproofDoor) {
            cell = new PdfPCell(new Phrase("Замок дополнительный", new Font(times, 12, Font.BOLD)));
            cell.setPaddingLeft(5);
            cell.setPaddingRight(5);
            cell.setPaddingTop(5);
            cell.setPaddingBottom(5);
            cell.setBorder(Rectangle.NO_BORDER);
            clientTable.addCell(cell);
            sellerTable.addCell(cell);

            cell = new PdfPCell(new Phrase(secondaryLock, new Font(times, 12)));
            cell.setPaddingLeft(5);
            cell.setPaddingRight(5);
            cell.setPaddingTop(5);
            cell.setPaddingBottom(5);
            cell.setBorder(Rectangle.NO_BORDER);
            clientTable.addCell(cell);
            sellerTable.addCell(cell);
        }

        cell = new PdfPCell(new Phrase("Ручка", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(handle, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Броненакладка", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(protector, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Дверной глазок", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(spyHole, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Наличники", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        StringBuilder platbandString = new StringBuilder(platbank + "\n");
        if (platbandWidth != null && !platbandWidth.isEmpty())
            platbandString.append("Ширина: " + platbandWidth +  " мм\n");
        cell = new PdfPCell(new Phrase(platbandString.toString(), new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Упаковка двери", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(packaging, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Доставка", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(shipping, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Монтаж", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(installation, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        if (comments != null) {
            cell = new PdfPCell(new Phrase("Комментарий", new Font(times, 12, Font.BOLD)));
            cell.setPaddingLeft(5);
            cell.setPaddingRight(5);
            cell.setPaddingTop(5);
            cell.setPaddingBottom(5);
            cell.setBorder(Rectangle.NO_BORDER);
            clientTable.addCell(cell);
            sellerTable.addCell(cell);

            cell = new PdfPCell(new Phrase(comments, new Font(times, 12)));
            cell.setPaddingLeft(5);
            cell.setPaddingRight(5);
            cell.setPaddingTop(5);
            cell.setPaddingBottom(5);
            cell.setBorder(Rectangle.NO_BORDER);
            clientTable.addCell(cell);
            sellerTable.addCell(cell);
        }

        cell = new PdfPCell(new Phrase("Стоимость заказа: ", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(totalPrice, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);

        BigDecimal bd = new BigDecimal(totalPrice).multiply(
                new BigDecimal(100).divide(new BigDecimal(100).add(new BigDecimal(profitPercent)),9, RoundingMode.HALF_UP));
        bd.setScale(2, RoundingMode.HALF_UP);

        Locale locale  = new Locale("en", "UK");
        String pattern = "###.##";
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        cell = new PdfPCell(new Phrase(decimalFormat.format(bd.doubleValue()), new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Дата заказа: ", new Font(times, 12, Font.BOLD)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        cell = new PdfPCell(new Phrase(orderDate, new Font(times, 12)));
        cell.setPaddingLeft(5);
        cell.setPaddingRight(5);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        cell.setBorder(Rectangle.NO_BORDER);
        clientTable.addCell(cell);
        sellerTable.addCell(cell);

        clientDocument.add(clientTable);
        sellerDocument.add(sellerTable);

//        Paragraph sellerTotalPrice = new Paragraph("Стоимость заказа: " + totalPrice, new Font(times, 12, Font.BOLD));
//
//        BigDecimal bd = new BigDecimal(totalPrice).add(new BigDecimal(totalPrice).multiply(new BigDecimal(profitPercent)).divide(new BigDecimal(100)));
//        bd.setScale(2, RoundingMode.HALF_UP);
//        Paragraph clientPrice = new Paragraph("Стоимость заказа: " + bd.doubleValue(), new Font(times, 12, Font.BOLD));
//        Paragraph pDate = new Paragraph("Дата заказа: " + orderDate, new Font(times, 12, Font.BOLD));
//        clientDocument.add(clientPrice);
//        sellerDocument.add(sellerTotalPrice);
//        clientDocument.add(pDate);
//        sellerDocument.add(pDate);

        // step 5
        clientDocument.close();
        sellerDocument.close();

        controller.incrementTodayOrders();

//        FileChooser fileChooser = new FileChooser();

        //Show save file dialog
//        File file = fileChooser.showSaveDialog(((Node)event.getTarget()).getScene().getWindow());

//        if(file != null){
//            FileWriter writer = new FileWriter(file);
//            writer.write();
//            writer.flush();
//            writer.close();
//        }
    }

    public static void main(String[] args) throws IOException, DocumentException {
        BlankOrder blankOrder = new BlankOrder(null, true, "Ivanov Ivan Ivanovich", "123-45-67", "Sikorskogo", "Seller information", "10",
                "3000", "2400", "1200", "2000", "900", "900",
                LabelNames.door50x30,LabelNames.singleDoorTopSideTransoms,
                "singleLeft.png",
                LabelNames.outerpaintingShagreen,"Brown","Configuration",LabelNames.outerNoTransomDecoration,
                LabelNames.innerPaintingPF,"Brown","Configuration",LabelNames.innerWithTransomDecoration,
                LabelNames.kale2000,LabelNames.elbor,LabelNames.apecsCromePlank,
                LabelNames.apecsProtectorCrome,LabelNames.spy10200,
                LabelNames.platbendAntic, "70",
                "Да","Нет","Нет",
                "Клиенту нужно срочно",
                "1000.00","11-05-2014");
        blankOrder.createTestDocument(null);
    }

}
