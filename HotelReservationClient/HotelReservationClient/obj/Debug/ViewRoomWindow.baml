   M S B A M L   `   `   `  ����Q  MHotelReservationClient, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null?$clr-namespace:HotelReservationClientHotelReservationClient  5   	   +    %HotelReservationClient.ViewRoomWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   6local$clr-namespace:HotelReservationClient     5   	     � Title$  	View Room��5   	   $	��450��6   $
��1000��6(   .��5	      � .+�5
   
   �� -   5         ��Name$ roomNumberLabel��5
      $��Room Number:��6)   $
��Left=�6@   $��	42,25,0,0q�6[   $	��Top=�6n   �� 5   
   -   5        $ bedsAmountLabel��5      $��Beds Amount:��6)   $
��Left=�6@   $��	42,65,0,0q�6[   $	��Top=�6n   �� 5   
   -   5        $ 
priceLabel��5      $��Price:��6$   $
��Left=�65   $��
42,105,0,0q�6P   $	��Top=�6d   �� 5   
   -   5        $ 
notesLabel��5      $��Notes:��6$   $
��Left=�65   $��255,279,0,0q�6P   $	��Top=�6e    J� RenderTransformOrigin$ 3.364,0.615&�6}   �� 5   
   -   5         ��Name$ 
roomNumber��5      $
��Left=�6&   $��23��6A   $��
160,28,0,0q�6M    �� TextWrapping$
 Wrap=�6a   $�� ��6u   $	��Top=�6}   $	��120��6�   {�.  6�   �� 5   
   -   5        $ 
bedsAmount��5      $
��Left=�6&   $��23��6A   $��
160,68,0,0q�6M   $
 Wrap=�6a   $�� ��6u   $	��Top=�6}   $	��120��6�   {�.  6�   �� 5   
   -   5        $ price��5      $
��Left=�6!   $��23��6<   $��160,108,0,0q�6H   $
 Wrap=�6]   $�� ��6q   $	��Top=�6y   $	��120��6�   {�.  6�   �� 5   
   -   5        $ notes��5      $
��Left=�6!   $	��111��6<   $��320,279,0,0q�6I   $	��Top=�6^   $	��488��6v   $
 Wrap=�6�   {�.  6�   &   System.Windows.Controls.DataGrid  5   
   -	   5          Name$ reservationsList��5      $	��200��6.   $��
320,65,0,0q�6;   $	��Top=�6O   $	��638��6g      CanUserAddRows .     AutoGenerateColumns .  $
��Left=�5   7   $��Stretch=�6R      ColumnWidth5  /System.Windows.Controls.DataGridLengthConverter$ * 6w   	   Columns	 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn
   Header$
 ReservationId��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6<   ��  �� Path$ reservationId�  5      $
 RoomId��6%    65   �� $ roomId�  5      $
 	Date From��6%    68   �� $ dateFrom� �� StringFormat$ 
dd-MM-yyyy��  5      $
 Date To��6%    66   �� $ dateTo�$ 
dd-MM-yyyy��  5      $
 Duration(days)��6%    6=   �� $ 
daysAmount�  5      $
 
Price(zł)��6%    68   �� $ price�5      �� 5   
   -
   5        $ label��5      $��Room's Reservations��6   $
��Left=�6=   $��
320,28,0,0q�6X   $	��Top=�6l   $	��150��6�   5      5       