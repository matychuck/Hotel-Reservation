   M S B A M L   `   `   `  ����Q  MHotelReservationClient, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null?$clr-namespace:HotelReservationClientHotelReservationClient  5   	   '    !HotelReservationClient.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   6local$clr-namespace:HotelReservationClient     5   	     � Title$  Hotel Reservation��5   	   $	��500��6#   $	��800��60   .��5	      �� .@�5
   
   �� $��Reservations��6   $��0,0,0,0q�6(   $	��250��69   .��5      �  � ColumnDefinitions 5      �� 5      $
��407* �6'   �� 5      $
��379* �6'   .+�5      &   System.Windows.Controls.DataGrid  -   5          Name$ reservationsList��5      $	��300��66   $��	35,70,0,0q�6C   $	��Top=�6V   $	��605��6n      CanUserAddRows .     AutoGenerateColumns .  $
��Left=�5   7   $��Stretch=�6R      ColumnWidth5  /System.Windows.Controls.DataGridLengthConverter$ * 6w   $��2��6�      
IsReadOnly .    Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ ReservationId��6-   1  +System.Windows.Controls.DataGridBoundColumn	   Binding	 6D   �� 
 �� Path$
 reservationId�  5      $ RoomId��6-   	 6=   �� $
 roomId�  5      $ 	Date From��6-   	 6@   �� $
 dateFrom� �� StringFormat$ 
dd-MM-yyyy��  5      $ Date To��6-   	 6>   �� $
 dateTo�$ 
dd-MM-yyyy��  5      $ Duration(days)��6-   	 6E   �� $
 
daysAmount�  5      $ 
Price(zł)��6-   	 6@   �� $
 price�5      �� 5      -   5         ��Name$ makeReservation��5      $	��New��62   $
��Left=�6@   $��
278,70,0,0q�6[   $	��Top=�6o   $��82��6�   $��30��6�   $��1��6�   �� 5      -   5        $ removeReservation��5      $��Delete��64   $
��Left=�6E   $��278,120,0,0q�6`   $	��Top=�6u   $��82��6�   $��30��6�   $��1��6�   �� 5       -   5        $ viewReservation��5       $
��View��62   $
��Left=�6A   $��278,170,0,0q�6\   $	��Top=�6q   $��82��6�   $��30��6�   $��1��6�   �� 5!      -   5         ��Name$ searchReservations��5!      $
��Left=�66   $��30��6Q   $��	35,25,0,0q�6]    �� TextWrapping$
 Wrap=�6p   $�� ��6�   $	��Top=�6�   $	��605��6�   $��2��6�   �� 5"      -   5         ��Name$ label��5"      $��Search��6'   $
��Left=�68   $��35,0,0,0q�6S   $	��Top=�6e   $	��105��6}   $��25��6�   5%      5&      �� 5'   
   $��Rooms��6   $��0,0,0,0q�6!   $	��250��62   .��5(      � .+�5)        -   5        $ 	roomsList��5)      $	��320��6/   $��	35,70,0,0q�6<   $	��Top=�6O   $	��605��6g    .   .  $
��Left=�5*   7   $��Stretch=�6R   $ * 6w    .  5,        5-      $ RoomId��6-   	 6=   �� $
 roomId�  5.      $ Room Number��6-   	 6B   �� $
 
roomNumber�  5/      $ Beds Amount��6-   	 6B   �� $
 
bedsAmount�  50      $ Price(zł)/Night��6-   	 6F   �� $
 price�  51      $ Notes��6-   	 6<   �� $
 notes�54      �� 56      -   5        $ 
createRoom��56      $	��New��6-   $
��Left=�6;   $��
685,70,0,0q�6V   $	��Top=�6j   $��82��6�   $��30��6�   6�   �� 57      -	   5        $ 
removeRoom��57      $��Delete��6-   $
��Left=�6>   $��685,120,0,0q�6Y   $	��Top=�6n   $��82��6�   $��30��6�   6�   �� 58      -
   5        $ 
updateRoom��58      $
��Edit��6-   $
��Left=�6<   $��685,170,0,0q�6W   $	��Top=�6l   $��82��6�   $��30��6�   6�   �� 59      -   5        $ viewRoom��59      $
��View��6+   $
��Left=�6:   $��685,220,0,0q�6U   $	��Top=�6j   $��82��6�   $��30��6�   6�   �� 5:      -   5        $ searchRooms��5:      $
��Left=�6/   $��30��6J   $��	35,25,0,0q�6V   $
 Wrap=�6i   $�� ��6}   $	��Top=�6�   $	��605��6�   6�   �� 5;      -   5        $ label2��5;      $��Search��6(   $
��Left=�69   $��35,0,0,0q�6T   $	��Top=�6f   $	��105��6~   $��25��6�   5>      5?      5@      5A      