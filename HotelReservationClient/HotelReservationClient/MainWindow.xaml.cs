using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using HotelReservationClient.HotelServer;

namespace HotelReservationClient
{
    /// <summary>
    /// Logika interakcji dla klasy MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        HotelServerClient server = new HotelServerClient(); //instancja serwera

        public MainWindow()
        {
            InitializeComponent();
            GetReservations();
            GetRooms();
        }

        #region Rezerwacje

        public void GetReservations()
        {
            try
            {
                reservationsList.ItemsSource = server.getReservations();
            }
            catch (Exception e)
            {
                reservationsList.ItemsSource = new List<reservation>();
            }
        }

        //Szukanie resezwacji po jakimkolwiek elemencie wchodzącym w jej skład
        private void SearchReservations_TextChanged(object sender, TextChangedEventArgs e)
        {
            List<reservation> reservationsCopy = new List<reservation>();
            string key = "";
            foreach (reservation reservation in server.getReservations())
            {
                key = String.Format("{0} {1} {2} {3} {4} {5}", reservation.reservationId, reservation.roomId, 
                    reservation.dateFrom.ToString("dd-MM-yyyy"), reservation.dateTo.ToString("dd-MM-yyyy"), reservation.daysAmount, reservation.price);

                if (key.ToLower().Contains(searchReservations.Text.ToLower()))
                {
                    reservationsCopy.Add(reservation);
                }
            }
            reservationsList.ItemsSource = reservationsCopy;
        }

        private void DeleteReservation_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                reservation selectedReservation = (reservation)reservationsList.SelectedItem;
                bool result = server.deleteReservation(selectedReservation.reservationId);
                if (result) MessageBox.Show("Reservation successfully removed!");
                else MessageBox.Show("Oops! Something went wrong");
                reservationsList.ItemsSource = server.getReservations();
            }
            catch(Exception exception)
            {
                //obsługa błędu przy próbie usunięcia gdy żadna rezerwacja nie została zaznaczona
            }
        }

        private void MakeReservation_Click(object sender, RoutedEventArgs e)
        {
            CreateReservationWindow createReservationWindow = new CreateReservationWindow(server);
            if(createReservationWindow.ShowDialog() == true)
            {

            }
            reservationsList.ItemsSource = server.getReservations();
        }

        private void ViewReservation_Click(object sender, RoutedEventArgs e)
        {
            ViewReservationWindow viewReservationWindow = new ViewReservationWindow(server);
            if(viewReservationWindow.ShowDialog() == true)
            {

            }
        }

        #endregion

        #region Pokoje

        public void GetRooms()
        {
            try
            {
                roomsList.ItemsSource = server.getRooms();
            }
            catch (Exception e)
            {
                roomsList.ItemsSource = new List<room>();
            }
        }

        private void CreateRoom_Click(object sender, RoutedEventArgs e)
        {
            CreateRoomWindow createRoomWindow = new CreateRoomWindow(server);
            if (createRoomWindow.ShowDialog() == true)
            {
                
            }
            roomsList.ItemsSource = server.getRooms();
        }

        private void DeleteRoom_Click(object sender, RoutedEventArgs e)
        {
            try { 
            room selectedRoom = (room)roomsList.SelectedItem;
            bool result = server.deleteRoom(selectedRoom.roomId);
            if (result) MessageBox.Show("Room successfully removed!");
            else MessageBox.Show("This room has been reserved!");
            roomsList.ItemsSource = server.getRooms();
            }
            catch (Exception exception)
            {
                //obsługa błędu przy próbie usunięcia gdy żaden pokój nie został zaznaczony
            }
        }

        //Szukanie pokoju po jakimkolwiek elemencie wchodzącym w jego skład
        private void SearchRooms_TextChanged(object sender, TextChangedEventArgs e)
        {
            List<room> roomsCopy = new List<room>();
            string key = "";
            foreach (room room in server.getRooms())
            {
                key = String.Format("{0} {1} {2} {3} {4}", room.roomId, room.roomNumber,
                    room.bedsAmount, room.price, room.notes);

                if (key.ToLower().Contains(searchRooms.Text.ToLower()))
                {
                    roomsCopy.Add(room);
                }
            }
            roomsList.ItemsSource = roomsCopy;
        }

        private void UpdateRoom_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                EditRoomWindow editRoomWindow = new EditRoomWindow(server);
                if (editRoomWindow.ShowDialog() == true)
                {

                }
                roomsList.ItemsSource = server.getRooms();
            }
            catch(Exception exception)
            {
                //obsługa błędu przy próbie edycji gdy żaden pokój nie został zaznaczony
            }
        }

        private void ViewRoom_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                ViewRoomWindow viewRoomWindow = new ViewRoomWindow(server);
                if(viewRoomWindow.ShowDialog() == true)
                {

                }
            }
            catch(Exception exception)
            {
                //obsługa błędu przy próbie podglądu gdy żaden pokój nie został zaznaczony
            }
        }


        #endregion

        
    }
}
