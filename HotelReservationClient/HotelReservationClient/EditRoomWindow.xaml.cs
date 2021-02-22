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
    /// Logika interakcji dla klasy EditRoomWindow.xaml
    /// </summary>
    public partial class EditRoomWindow : Window
    {
        static MainWindow mainWindow;
        HotelServerClient server;
        room selectedRoom;

        public EditRoomWindow()
        {
            InitializeComponent();
        }

        public EditRoomWindow(HotelServerClient server)
        {
            InitializeComponent();
            this.server = server;

            foreach (Window w in Application.Current.Windows)
            {
                if (w is MainWindow)
                    mainWindow = (MainWindow)w;
            }

            selectedRoom = (room)mainWindow.roomsList.SelectedItem;
            roomNumber.Text = selectedRoom.roomNumber.ToString();
            bedsAmount.Text = selectedRoom.bedsAmount.ToString();
            price.Text = selectedRoom.price.ToString();
            notes.Text = selectedRoom.notes.ToString();
            
        }

        private void EditRoomBtn_Click(object sender, RoutedEventArgs e)
        {
            server.editRoom(selectedRoom.roomId, int.Parse(roomNumber.Text), int.Parse(bedsAmount.Text), double.Parse(price.Text), notes.Text);
            this.Close();
        }

        private void CancelBtn_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
