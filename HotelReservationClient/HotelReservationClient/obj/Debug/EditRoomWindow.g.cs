﻿#pragma checksum "..\..\EditRoomWindow.xaml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "DB1C532BD175146611838CFC48EFDEA963B4A227"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using HotelReservationClient;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace HotelReservationClient {
    
    
    /// <summary>
    /// EditRoomWindow
    /// </summary>
    public partial class EditRoomWindow : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 10 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label roomNumberLabel;
        
        #line default
        #line hidden
        
        
        #line 11 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label bedsAmountLabel;
        
        #line default
        #line hidden
        
        
        #line 12 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label priceLabel;
        
        #line default
        #line hidden
        
        
        #line 13 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label notesLabel;
        
        #line default
        #line hidden
        
        
        #line 14 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox roomNumber;
        
        #line default
        #line hidden
        
        
        #line 15 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox bedsAmount;
        
        #line default
        #line hidden
        
        
        #line 16 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox price;
        
        #line default
        #line hidden
        
        
        #line 17 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button editRoomBtn;
        
        #line default
        #line hidden
        
        
        #line 18 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button cancelBtn;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\EditRoomWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox notes;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/HotelReservationClient;component/editroomwindow.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\EditRoomWindow.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.roomNumberLabel = ((System.Windows.Controls.Label)(target));
            return;
            case 2:
            this.bedsAmountLabel = ((System.Windows.Controls.Label)(target));
            return;
            case 3:
            this.priceLabel = ((System.Windows.Controls.Label)(target));
            return;
            case 4:
            this.notesLabel = ((System.Windows.Controls.Label)(target));
            return;
            case 5:
            this.roomNumber = ((System.Windows.Controls.TextBox)(target));
            return;
            case 6:
            this.bedsAmount = ((System.Windows.Controls.TextBox)(target));
            return;
            case 7:
            this.price = ((System.Windows.Controls.TextBox)(target));
            return;
            case 8:
            this.editRoomBtn = ((System.Windows.Controls.Button)(target));
            
            #line 17 "..\..\EditRoomWindow.xaml"
            this.editRoomBtn.Click += new System.Windows.RoutedEventHandler(this.EditRoomBtn_Click);
            
            #line default
            #line hidden
            return;
            case 9:
            this.cancelBtn = ((System.Windows.Controls.Button)(target));
            
            #line 18 "..\..\EditRoomWindow.xaml"
            this.cancelBtn.Click += new System.Windows.RoutedEventHandler(this.CancelBtn_Click);
            
            #line default
            #line hidden
            return;
            case 10:
            this.notes = ((System.Windows.Controls.TextBox)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}
