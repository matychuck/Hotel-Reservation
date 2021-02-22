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
    /// Logika interakcji dla klasy ViewReservationWindow.xaml
    /// </summary>
    public partial class ViewReservationWindow : Window
    {

        static MainWindow mainWindow;
        HotelServerClient server;
        reservation selectedReservation;

        public ViewReservationWindow()
        {
            InitializeComponent();
        }

        public ViewReservationWindow(HotelServerClient server)
        {
            InitializeComponent();
            this.server = server;

            foreach (Window w in Application.Current.Windows)
            {
                if (w is MainWindow)
                    mainWindow = (MainWindow)w;
            }

            selectedReservation = (reservation)mainWindow.reservationsList.SelectedItem;

            roomNumber.Text = server.getRoom(selectedReservation.roomId).roomNumber.ToString();
            dateFrom.Text = selectedReservation.dateFrom.ToString("dd-MM-yyyy");
            dateTo.Text = selectedReservation.dateTo.ToString("dd-MM-yyyy");
            duration.Text = selectedReservation.daysAmount.ToString();
            price.Text = selectedReservation.price.ToString();
        }
    }
}
