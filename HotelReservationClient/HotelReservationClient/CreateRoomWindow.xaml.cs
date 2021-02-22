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
    /// Logika interakcji dla klasy CreateRoomWindow.xaml
    /// </summary>
    public partial class CreateRoomWindow : Window
    {
        HotelServerClient server;

        public CreateRoomWindow()
        {
            InitializeComponent();
        }

        public CreateRoomWindow(HotelServerClient server)
        {
            InitializeComponent();
            this.server = server;
        }

        private void CancelBtn_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void CreateRoomBtn_Click(object sender, RoutedEventArgs e)
        {
           server.addRoom(int.Parse(roomNumber.Text), int.Parse(bedsAmount.Text), double.Parse(price.Text), notes.Text);
           this.Close();
        }
    }
}
