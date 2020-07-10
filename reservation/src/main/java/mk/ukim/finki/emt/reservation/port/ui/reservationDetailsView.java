//package mk.ukim.finki.emt.reservation.port.ui;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.Html;
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.*;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.textfield.TextArea;
//
//
//import mk.ukim.finki.emt.reservation.application.ReservationCatalog;
//import mk.ukim.finki.emt.reservation.application.form.BookItemForm;
//import mk.ukim.finki.emt.reservation.domain.model.Reservation;
//import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
//
//import java.awt.*;
//import java.util.Optional;
//
//@Route("reservation")
//@PageTitle("Show reservation")
//public class reservationDetailsView extends VerticalLayout implements HasUrlParameter<String> {
//
//    private final ReservationCatalog reservationCatalog;
//
//    public reservationDetailsView(ReservationCatalog reservationCatalog) {
//        this.reservationCatalog = reservationCatalog;
//        setSizeFull();
//    }
//
//    @Override
//    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String parameter) {
//        Optional<Reservation> reservation = Optional.ofNullable(parameter).map(ReservationId::new).flatMap(reservationCatalog::findByIdOptional);
//
//        if(reservation.isPresent()){
//            showReservation(reservation.get());
//        }else{
//            showNoSuchReservation();
//        }
//
//    }
//
//    private void showReservation(Reservation reservation) {
//        var title = new Html("<h3>Reservation Details</h3>");
//        add(title);
//
//        var header = new FormLayout();
//        header.addFormItem(createReadOnlyTextField(reservation.getDateTakingReservation().toString()), "Ordered on");
//        header.addFormItem(createReadOnlyTextField(reservation.getStatus().toString()), "Status");
//        add(header);
//
//    }
//
//    private TextField createReadOnlyTextField(String value) {
//        var textField = new TextField();
//        textField.setReadOnly(true);
//        textField.setValue(value);
//        return textField;
//    }
//    private void showNoSuchReservation () {
//        add(new Text("The order does not exist."));
//    }
//
//}
