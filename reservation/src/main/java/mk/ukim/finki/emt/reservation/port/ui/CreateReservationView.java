//package mk.ukim.finki.emt.reservation.port.ui;
//import com.vaadin.flow.component.Html;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.combobox.ComboBox;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.tabs.Tabs;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.data.binder.Setter;
//import com.vaadin.flow.data.converter.StringToIntegerConverter;
//import com.vaadin.flow.function.ValueProvider;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//import mk.ukim.finki.emt.reservation.application.BookCatalog;
//import mk.ukim.finki.emt.reservation.application.ReservationCatalog;
//import mk.ukim.finki.emt.reservation.application.form.BookItemForm;
//import mk.ukim.finki.emt.reservation.application.form.ReservationForm;
//import mk.ukim.finki.emt.reservation.domain.model.Book;
//
//import java.util.Collection;
//
//@Route(value = "create-reservation")
//@PageTitle("Create Reservation")
//public class CreateReservationView extends VerticalLayout {
//
//    private final BookCatalog bookCatalog;
//    private final ReservationCatalog reservationCatalog;
//    private final Binder<ReservationForm> binder;
//    private final Grid<BookItemForm> itemFormGrid;
//
//
//    public CreateReservationView(BookCatalog bookCatalog, ReservationCatalog reservationCatalog) {
//        this.bookCatalog = bookCatalog;
//        this.reservationCatalog = reservationCatalog;
//
//        setSizeFull();
//
//        this.binder =  new Binder<>();
//
//        var title = new Html("<h3>Create reservation</h3>");
//        add(title);
//
//        var tabs = new Tabs();
//        tabs.setWidth("100%");
//        add(tabs);
//
//        var tabContainer = new TabContainer(tabs);
//        tabContainer.setWidth("100%");
//        tabContainer.setHeight("100%");
//        add(tabContainer);
//
//        itemFormGrid = new Grid<>();
//        itemFormGrid.addColumn(form -> form.getBook().getBookName()).setHeader("Book");
//        itemFormGrid.addColumn(BookItemForm::getQuantity).setHeader("quantity");
//
//        var orderItemLayout = new ReservationBookLayout();
//        tabContainer.addTab("Books", new Div(itemFormGrid, orderItemLayout));
//
//        var createOrder = new Button("Create Reservation", evt -> createOrder());
//
//    }
//
//    private void createOrder(){
//        try {
//            var reservationId = reservationCatalog.createReservation(binder.getBean());
//            getUI().ifPresent(ui -> ui.navigate(reservationDetailsView.class, reservationId.getId()));
//        } catch (Exception ex){
//            Notification.show(ex.getMessage());
//        }
//    }
//
//    private void addBook(BookItemForm item){
//        binder.getBean().setBookId(item.getBook().getId());
//        itemFormGrid.setItems((Collection<BookItemForm>) binder.getBean().getBookId());
//    }
//
//
//
//
//    class ReservationBookLayout extends HorizontalLayout {
//        private Binder<BookItemForm> binder;
//        private ComboBox<Book> book;
//        private TextField bookName;
//        private TextField bookAuthor;
//        private Button addBook;
//
//        ReservationBookLayout(){
//            setWidth("630px");
//            setAlignItems(Alignment.END);
//
//            book = new ComboBox<>("Book", bookCatalog.findAll());
//            book.setItemLabelGenerator(Book::getBookName);
//            add(book);
//
//            bookName = new TextField("Book Name");
//            bookName.setReadOnly(true);
//            bookName.setWidth("100%");
//            add(bookName);
//
//            bookAuthor = new TextField("Author");
//            bookAuthor.setReadOnly(true);
//            bookAuthor.setWidth("100px");
//            add(bookAuthor);
//
//
//            addBook = new Button("Add", evt -> {
//                addBook(binder.getBean());
//                binder.setBean(new BookItemForm());
//                addBook.setEnabled(false);
//            });
//            addBook.setEnabled(false);
//            add(addBook);
//
//            binder = new Binder<>();
//            binder.forField(book)
//                    .asRequired()
//                    .bind(BookItemForm::getBook, BookItemForm::setBook);
//            binder.addValueChangeListener(evt -> addBook.setEnabled(binder.isValid()));
//            binder.setBean(new BookItemForm());
//
//        }
//    }
//}
