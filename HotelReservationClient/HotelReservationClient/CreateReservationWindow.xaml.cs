using HotelReservationClient.HotelServer;
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
using System.Windows.Shapes;

namespace HotelReservationClient
{
    /// <summary>
    /// Logika interakcji dla klasy CreateReservationWindow.xaml
    /// </summary>
    public partial class CreateReservationWindow : Window
    {

        static MainWindow mainWindow;
        HotelServerClient server;

        public CreateReservationWindow()
        {
            InitializeComponent();
        }

        public CreateReservationWindow(HotelServerClient server)
        {
            InitializeComponent();
            this.server = server;
            roomsNumber.ItemsSource = server.getRooms().Select(x => x.roomNumber).ToList();
        }

        private void MakeReservationBtn_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int selectedRoomNumber = (int)roomsNumber.SelectedItem;
                int reservedRoomId = server.getRooms().Where(x => x.roomNumber == selectedRoomNumber).First().roomId;
                bool result = server.addReservation(reservedRoomId, dateFrom.SelectedDate.Value, dateTo.SelectedDate.Value);

                if (result)
                {
                    MessageBox.Show("Reservation booked successfully");
                    this.Close();
                }
                else MessageBox.Show("Sorry. This date is unavailable");
            }
            catch(Exception exception)
            {
                MessageBox.Show("Choose valid data!");
            }
            
        }
    }
}
